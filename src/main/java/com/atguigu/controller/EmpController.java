package com.atguigu.controller;

import com.atguigu.domain.Employee;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

/**
 * @author yinhuidong
 * @createTime 2020-05-27-8:13
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmployeeService service;

    @RequestMapping("/list")
    public String list(
            @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
            Model model) {
        if(pageNum<=0){
            pageNum=1;
        }
        List<Employee> list = service.findByPage(pageNum, pageSize);
        model.addAttribute("pageInfo",new PageInfo<Employee>(list));
        return "EmpList";
    }
    @ResponseBody
    @RequestMapping("/add")
    public Employee add(@RequestBody Employee employee){

        System.out.println("employee = " + employee);
        service.insert(employee);
        return employee;
    }

    @RequestMapping("/del")
    public String delete(@RequestParam("id") Integer id){
        service.delete(id);
        return "redirect:/emp/list";
    }
    @RequestMapping("/huixian")
    public String huixian(@RequestParam("id") Integer id,Model model){
        Employee employee = service.huixian(id);
        model.addAttribute("emp",employee);
        return "emp-update";
    }
    @ResponseBody
    @RequestMapping("/update")
    public Employee update(@RequestBody Employee employee){
        service.update(employee);
        return employee;
    }
    @ResponseBody
    @RequestMapping("/dels")
    public String dels(Integer[] ids){
        service.dels(ids);
        return "{\"success\":\"success\"}";
    }
}
