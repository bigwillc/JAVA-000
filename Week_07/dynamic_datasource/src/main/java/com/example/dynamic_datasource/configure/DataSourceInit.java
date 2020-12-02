package com.example.dynamic_datasource.configure;

import com.example.dynamic_datasource.strategy.DeterminDataSourceByRandom;

import java.util.ArrayList;
import java.util.List;

public class DataSourceInit {

    private static ThreadLocal<DataSourceType> currentDataSource = new ThreadLocal<>();

    public static DeterminDataSourceByRandom strategy = new DeterminDataSourceByRandom();

    public static void putDataSource(DataSourceType dataSourceType){ currentDataSource.set(dataSourceType);}

    public static DataSourceType getDataSource() {
        return currentDataSource.get();
    }

    public static void clear() {
        currentDataSource.remove();
    }

    public static void setSlave() {
        List<DataSourceType> list = new ArrayList<>();
        list.add(DataSourceType.SLAVE_1);
        list.add(DataSourceType.SLAVE_2);
        DataSourceInit.putDataSource(strategy.determinDataSource(list));
    }
}
