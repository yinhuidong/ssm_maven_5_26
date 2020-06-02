package com.atguigu.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yinhuidong
 * @createTime 2020-05-26-0:07
 */
public class Employee {

    private Integer id;
    private String empName;
    private Integer age;
    private String email;
    private Date birth;
    private Department dept;
    private String birstr;

    public Employee() {
    }

    public Employee(Integer id, String empName, Integer age, String email, Date birth, Department dept,String birstr) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.email = email;
        this.birth = birth;
        this.dept = dept;
        this.birstr=birstr;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", dept=" + dept +
                '}';
    }
    public String getBirstr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(this.birth);
    }

    public void setBirstr(String birstr) {
        this.birstr = birstr;
    }
}
