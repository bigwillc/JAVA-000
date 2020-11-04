package io.github.kimmking.gateway.inbound;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpInboundServer {
    private static Logger logger = LoggerFactory.getLogger(HttpInboundServer.class);

    private int port;
    
    private String proxyServer;

    public HttpInboundServer(int port, String proxyServer) {
        this.port=port;
        this.proxyServer = proxyServer;
    }

    public void run() throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 128)  //建立过程中未完成的连接可以保存多少个
                    .option(ChannelOption.TCP_NODELAY, true)  //是否开启Nagle算法， false 高并发下更有好
                    .option(ChannelOption.SO_KEEPALIVE, true) // tcp保持长连接
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_RCVBUF, 32 * 1024) // 缓冲区 一般32K
                    .option(ChannelOption.SO_SNDBUF, 32 * 1024) // 缓冲区
                    .option(EpollChannelOption.SO_REUSEPORT, true) //
                    .childOption(ChannelOption.SO_KEEPALIVE, true) // 设置在work的上面
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT); //配置ByteBuff的内存池

            // 绑定boos group 和work group，绑定NIO的操作, child hander 绑定的InBound的参数
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)).childHandler(new HttpInboundInitializer(this.proxyServer));

            Channel ch = b.bind(port).sync().channel();
            logger.info("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
