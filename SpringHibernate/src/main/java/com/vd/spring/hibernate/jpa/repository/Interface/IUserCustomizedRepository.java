package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.User;

public interface IUserCustomizedRepository {

    public User findFirstByEmailAndPasswordAndRole(String email, String password, String role);

    public User findFirstByEmailAndRole(String email, String role);
}