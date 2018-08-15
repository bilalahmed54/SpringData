package com.vd.spring.hibernate.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringHibernateAPIs {

    @RequestMapping("/")
    public String index() {
        return "Hello World - Spring Hibernate JPA";
    }

}