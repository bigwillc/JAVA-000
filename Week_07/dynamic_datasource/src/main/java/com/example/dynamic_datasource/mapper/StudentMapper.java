package com.example.dynamic_datasource.mapper;

import com.example.dynamic_datasource.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into t_user_info (id, name, address)"
            + "values (#{id}, #{name}, #{address})")
    int save(Student student);

    @Select("select * from t_user_info")
    List<Student> selectAll();
}
