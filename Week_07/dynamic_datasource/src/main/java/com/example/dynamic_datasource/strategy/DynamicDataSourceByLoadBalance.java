package com.example.dynamic_datasource.strategy;

import com.example.dynamic_datasource.configure.DataSourceType;

import java.util.List;

public class DynamicDataSourceByLoadBalance implements DynamicDataSourceStrategy {
    @Override
    public DataSourceType determinDataSource(List<DataSourceType> dataSourceList) {
        return null;
    }
}
