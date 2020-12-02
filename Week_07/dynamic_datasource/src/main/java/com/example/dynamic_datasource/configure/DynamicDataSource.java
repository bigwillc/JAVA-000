package com.example.dynamic_datasource.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("当前数据源是 {}", DataSourceInit.getDataSource());
        if (null == DataSourceInit.getDataSource()) {
            DataSourceInit.setSlave();
        }
        return DataSourceInit.getDataSource();
    }
}
