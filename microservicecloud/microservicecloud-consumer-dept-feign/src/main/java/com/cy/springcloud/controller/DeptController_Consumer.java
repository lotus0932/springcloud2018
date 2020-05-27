package com.cy.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.springcloud.entities.Dept;
import com.cy.springcloud.service.DeptClientService;

@RestController
public class DeptController_Consumer {
    //private static final String REST_URL_PREFIX="http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
    @Autowired
    private DeptClientService service = null;
    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return service.add(dept);
    }
    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return service.list();
    }
}
