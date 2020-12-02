package com.example.dynamic_datasource.strategy;

import com.example.dynamic_datasource.configure.DataSourceType;

import java.util.List;

public interface DynamicDataSourceStrategy {
    DataSourceType determinDataSource(List<DataSourceType> dataSourceList);
}
