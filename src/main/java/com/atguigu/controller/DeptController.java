package com.atguigu.controller;

import com.atguigu.domain.Department;
import com.atguigu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-21:36
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService service;
    @ResponseBody
    @RequestMapping("/list")
    public List list(Model model){
        List<Department> depts = service.findAll();
        model.addAttribute("depts",depts);
        return depts;
    }
}
