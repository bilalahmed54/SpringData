package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.Project;
import com.vd.spring.hibernate.jpa.repository.Interface.CustomisedRepoInterface.IProjectCustomizedRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Long>, IProjectCustomizedRepository {

}