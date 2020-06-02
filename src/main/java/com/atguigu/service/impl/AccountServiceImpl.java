package com.atguigu.service.impl;

import com.atguigu.domain.Account;
import com.atguigu.mapper.AccountMapper;
import com.atguigu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-18:56
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;
    @Override
    public List<Account> findAll() {
        return mapper.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return mapper.findById(id);
    }

    @Override
    public Integer count() {
        return mapper.count();
    }

    @Override
    public void add(Account account) {
        mapper.add(account);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void update(Account account) {
        mapper.update(account);
    }
}
