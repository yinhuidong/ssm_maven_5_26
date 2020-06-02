package com.atguigu.mapper;

import com.atguigu.domain.Department;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-21:23
 */
@Repository
public interface DepartmentMapper {

    @Results(id = "deptMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "salary",property = "salary")
    })
    @Select("select id ,name,salary from department where id = #{id};")
    Department findById(Integer id);
    @ResultMap("deptMap")
    @Select("select id ,name,salary from department;")
    List<Department> findAll();
}
