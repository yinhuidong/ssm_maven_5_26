package com.atguigu.service;

import com.atguigu.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-18:55
 */
public interface AccountService {
    //查询所有
    List<Account> findAll();

    //根据idchaxun
    Account findById(Integer id);

    //总数
    Integer count();
    //添加
    void add(Account account);
    //删除
    void delete(Integer id);
    //修改
    void update(Account account);

}
