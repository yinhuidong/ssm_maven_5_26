package com.atguigu.service;

import com.atguigu.domain.Employee;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-21:39
 */
public interface EmployeeService {

    List<Employee> findByPage(Integer pageNum,Integer pageSize);
    void insert(Employee employee);
    void delete(Integer id);
    Employee huixian(Integer id);
    void update(Employee employee);
    void dels(Integer[]ids);
}
