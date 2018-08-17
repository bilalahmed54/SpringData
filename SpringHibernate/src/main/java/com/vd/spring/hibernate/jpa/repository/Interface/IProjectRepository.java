package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Long>, IProjectCustomizedRepository {

}