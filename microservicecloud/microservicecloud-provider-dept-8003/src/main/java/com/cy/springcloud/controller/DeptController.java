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


@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
       return deptService.findById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.findAll();
    }
    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }
}
