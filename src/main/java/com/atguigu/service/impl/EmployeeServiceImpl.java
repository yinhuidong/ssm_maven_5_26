package com.atguigu.service.impl;

import com.atguigu.domain.Employee;
import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-21:41
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper mapper;
    @Override
    public List<Employee> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.findAll();
    }

    @Override
    public void insert(Employee employee) {
        mapper.insert(employee);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public Employee huixian(Integer id) {
        return mapper.findById(id);
    }

    @Override
    public void update(Employee employee) {
        mapper.update(employee);
    }

    @Override
    public void dels(Integer[] ids) {
        mapper.dels(ids);
    }
}
