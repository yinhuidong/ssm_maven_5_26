package com.atguigu.mapper;

import com.atguigu.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-21:14
 */
@Repository
public interface EmployeeMapper {
    @Results(id = "empMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "emp_name", property = "empName"),
            @Result(column = "age", property = "age"),
            @Result(column = "email", property = "email"),
            @Result(column = "birth", property = "birth"),
            @Result(property = "dept", column = "dept_id", one = @One(select = "com.atguigu.mapper.DepartmentMapper.findById"))
    })
    @Select("select id ,emp_name ,age , email ,birth ,dept_id from employee ")
    List<Employee> findAll();

    @Insert("insert into employee (emp_name,age,email,birth,dept_id)values(#{empName},#{age},#{email},#{birth},#{dept.id})")
    void insert(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void delete(Integer id);

    @ResultMap("empMap")
    @Select("select id ,emp_name ,age , email ,birth ,dept_id from employee where id=#{id}")
    Employee findById(Integer id);

    @Update("update employee set emp_name=#{empName},age=#{age},email=#{email},birth=#{birth},dept_id=#{dept.id} where id=#{id}")
    void update(Employee employee);

//    @Delete("delete from employee where id in " + "<foreach collection='array' item='id' open='('separator=',' close=')'> " +
//            "#{id}" +
//            "</foreach>")
    @Delete("<script>"+"delete from employee where id in\n" +
            "        <foreach collection=\"array\" item=\"id\" separator=\",\" open=\"(\" close=\")\">\n" +
            "            #{id}\n" +
            "        </foreach>"+"</script>")
    void dels(Integer[] ids);



}
