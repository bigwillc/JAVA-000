
@[TOC](Java 总结)
# JVM
## Java 字节码
## JVM内存模型
## JVM类加载器
## JVM 命令行参数
## GC 算法
通过可达性来判断是否需要回收
* 串行GC
* 并行GC
* CMS GC
* G1 GC
## 常用JVM 分析工具
## JVM调优
# NIO & Netty
## NIO原理
## Netty 的实现原理
## 如何使用Netty实现NIO
# 并发编程
## 多线程基础
## Java 多线程
## 线程安全
* 线程安全类型
### 加锁需要考虑的问题
1. 粒度
2. 性能
3. 重入
4. 公平
5. 自旋锁
6. 场景：脱离场景谈性能都是耍流氓
## 线程池原理与应用
1. Executor: 执行者
	* 任务执行器
	* submit - 有返回值，用future封装
	* execute - 无返回值
2. ExecutorService：接口API
	* 执行可运行的任务
	* 关闭线程池
	* 立即关闭
	* 提交任务，允许获取执行结果
	* 提交任务
3. ThreadFactory：线程工厂
	* 创建新线程
	* 加入到工作队列
4. Excutors：工具类
## Java并发包
* 锁
* 原子类
* 线程池
* 工具类
* 集合类
# Spring
## Spring框架设计
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210205150630697.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM1MTE1OTQy,size_16,color_FFFFFF,t_70)

## AOP详解
## Bean核心原理
## Spring XML配置原理
## Spring Messaging等技术
## Java 的一些进阶
1. Java8 Lambda
2. Java8 Stream
3. Lombok
4. Guava
5. 设计原则
6. 设计模式
7. 单元测试
# MySQL
## 性能与sql优化
DB是优化业务系统的核心
## 关系型数据库MySQL
## 深入数据库原理
## MySQL配置优化
* 连接请求的变量
	* max_connections
	* back_log
	* wait_timeout & interative_timeout
* 缓冲区变量
	* key_buffer_size
	* query_cache_size
	* max_connect_errors
	* ...
## 数据库设计优化
1. 恰当的选择引擎
2. 合理的拆分宽表
3. 选择恰当的数据类型：明确，尽量小

* 唯一约束和索引
* 是否可以使用冗余字段
* 自增主键
* 数据库碎片问题
* 如何快速导入导出、备份数据
## MySQL事务和锁
* ACID
	* 原子性
	* 一致性
	* 隔离性
	* 持久性 
* 锁
	* 行级锁
	* 表级锁
## DB与SQL优化
* 主从复制
	* 异步复制
	* 半同步复制
	* 组复制
* 读写分离
## 数据库拆分与分库分表
1. 为什么要做数据库拆分
2. 数据库垂直拆分
3. 数据库水平拆分
4. 相关的框架和中间件
5. 如何做数据迁移
# 分布式事务
1. 分布式事务
2. XA分布式事务
3. BASE柔性事务
4. TCC/AT以及相关框架
5. ShardingSphere对分布式事务的支持
# RPC与分布式服务化
1. RPC基本原理
	* 设计
	* 代理
	* 序列化
	* 网络传输
	* 查找实现类
3. RPC技术框架
4. 如何设计一个RPC
5. 从RPC到分布式服务化
## 从RPC走向服务化
* 分布式服务治理
* 配置/ 注册/ 元数据中心
* 服务的注册与发现
* 服务的集群与路由
* 服务的过滤与流控
## 微服务架构
