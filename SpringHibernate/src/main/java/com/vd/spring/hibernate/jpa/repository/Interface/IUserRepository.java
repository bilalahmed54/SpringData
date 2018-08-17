package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>, IUserCustomizedRepository {

}