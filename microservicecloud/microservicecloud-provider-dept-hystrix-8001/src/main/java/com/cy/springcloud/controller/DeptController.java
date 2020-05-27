package com.cy.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.springcloud.entities.Dept;
import com.cy.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;


@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept=deptService.findById(id);
        if(null==dept) {
            throw new RuntimeException("该ID："+id+"没有没有对应的信息");
        }
       return dept;
    }
    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.findAll();
    }
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        Dept dept=new Dept();
        dept.setDeptno(id);
        dept.setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand");
        dept.setDb_source("no this database in MySQL");
        return dept;
    }
}
