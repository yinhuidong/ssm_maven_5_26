package com.atguigu.service;

import com.atguigu.domain.Department;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-21:39
 */
public interface DeptService {

    List<Department> findAll();
}
