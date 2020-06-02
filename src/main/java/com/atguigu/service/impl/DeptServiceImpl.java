package com.atguigu.service.impl;

import com.atguigu.domain.Department;
import com.atguigu.mapper.DepartmentMapper;
import com.atguigu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-21:39
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DepartmentMapper mapper;
    @Override
    public List<Department> findAll() {
        return mapper.findAll();
    }
}
