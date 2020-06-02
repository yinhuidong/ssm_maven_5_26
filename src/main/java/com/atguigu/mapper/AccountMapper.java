package com.atguigu.mapper;

import com.atguigu.domain.Account;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-18:45
 */
@Repository
public interface AccountMapper {
    //查询所有
    @Results(id = "acc",
    value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "salary",property = "salary"),
    })
    @Select("select * from account")
    List<Account> findAll();

    @ResultMap("acc")
    @Select("select * from account where id = #{id}")
    Account findById(Integer id);

    @Select("select count(*) from account ;")
    Integer count();
    @Insert("insert into account(name,salary)values(#{name},#{salary})")
    void add(Account account);
    @Delete("delete from account where id =#{id}")
    void delete(Integer id);
    @Update({"update account set name=#{name},salary=#{salary} where id =#{id}"})
    void update(Account account);
}
