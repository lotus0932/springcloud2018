package com.cy.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cy.springcloud.entities.Dept;
import com.cy.springcloud.service.DeptService;


@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @RequestMapping(value="/dept/add",method=RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
     return service.addDept(dept);
    }

    

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)

    public Dept get(@PathVariable("id") Long id)
    {
     return service.findById(id);
    }

    

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list()
    {
     return service.findAll();
    }
}
