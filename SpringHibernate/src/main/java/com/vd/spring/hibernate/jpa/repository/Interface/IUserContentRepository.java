package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.ContentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import com.vd.spring.hibernate.jpa.repository.Interface.CustomisedRepoInterface.IUserContentCustomizedRepository;

public interface IUserContentRepository extends JpaRepository<ContentUser, Long>, IUserContentCustomizedRepository {

}