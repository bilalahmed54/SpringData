package com.vd.spring.hibernate.jpa.controller;

import com.vd.spring.hibernate.jpa.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vd.spring.hibernate.jpa.service.Interface.IUserService;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public UserDTO signUp(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "password", required = true) String password,
                          @RequestParam(value = "role", required = true) String role,
                          @RequestParam(value = "email", required = true) String email,
                          @RequestParam(value = "gender", required = true) String gender,
                          @RequestParam(value = "dateOfBirth", required = true) Long dateOfBirth,
                          @RequestParam(value = "location", required = true) String location) {

        Date dateOfBirthObj = new Date(dateOfBirth);
        return iUserService.signUp(name, password, role, email, gender, dateOfBirthObj, location);
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public UserDTO signIn(@RequestParam(value = "email", required = true) String email,
                          @RequestParam(value = "password", required = true) String password,
                          @RequestParam(value = "role", required = true) String role) {

        return iUserService.signIn(email, password, role);
    }
}