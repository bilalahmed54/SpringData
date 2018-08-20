package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vd.spring.hibernate.jpa.repository.Interface.CustomisedRepoInterface.IUserCustomizedRepository;

public interface IUserContentRepository extends JpaRepository<User, Long>, IUserCustomizedRepository {

}