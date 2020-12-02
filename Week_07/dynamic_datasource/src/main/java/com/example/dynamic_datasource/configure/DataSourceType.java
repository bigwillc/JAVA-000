package com.example.dynamic_datasource.configure;

import lombok.Getter;
import lombok.Setter;

public enum DataSourceType {

    // 主库
    MASTER("master"),
    // 从库1
    SLAVE_1("slave1"),
    // 从库2
    SLAVE_2("slave2");

    @Getter
    @Setter
    private String name;

    DataSourceType(String name){
        this.name = name;
    }
}
