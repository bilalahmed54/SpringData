package com.vd.spring.hibernate.jpa.service.Interface;

import java.util.Date;
import com.vd.spring.hibernate.jpa.dto.UserDTO;

public interface IUserService {

    public UserDTO signUp(String name, String password, String role, String email, String gender, Date dateOfBirth, String location);
    public UserDTO signIn(String email, String password, String role);
}