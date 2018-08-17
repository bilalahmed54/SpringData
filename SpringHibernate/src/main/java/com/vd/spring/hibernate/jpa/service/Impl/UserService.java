package com.vd.spring.hibernate.jpa.service.Impl;

import org.springframework.stereotype.Service;
import com.vd.spring.hibernate.jpa.dto.UserDTO;
import com.vd.spring.hibernate.jpa.model.core.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.vd.spring.hibernate.jpa.service.Interface.IUserService;
import com.vd.spring.hibernate.jpa.repository.Interface.IUserRepository;

import java.util.Date;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserDTO signUp(String name, String password, String role, String email, String gender, Date dateOfBirth, String location) {

        UserDTO userDTO = new UserDTO();

        User user = iUserRepository.findFirstByEmailAndRole(email, role);

        if (user == null) {

            user = new User(name, password, role, email, gender, dateOfBirth, location);

            iUserRepository.save(user);

            userDTO.setStatus(200);
            userDTO.setAppErrorCode(200);
            userDTO.setMessage("User Created Successfully.");

        } else {

            userDTO.setStatus(409);
            userDTO.setAppErrorCode(409);
            userDTO.setMessage("User Already Exist.");
        }

        userDTO.setUser(user);

        return userDTO;
    }

    @Override
    public UserDTO signIn(String email, String password, String role) {

        UserDTO userDTO = new UserDTO();

        User user = iUserRepository.findFirstByEmailAndPasswordAndRole(email, password, role);

        if (user == null) {

            userDTO.setStatus(401);
            userDTO.setAppErrorCode(401);
            userDTO.setMessage("Invalid Email or Password.");

        } else {

            userDTO.setStatus(200);
            userDTO.setAppErrorCode(200);
            userDTO.setJwt("1234567891011");
            userDTO.setMessage("User LoggedIn Successfully.");
        }

        userDTO.setUser(user);

        return userDTO;
    }
}