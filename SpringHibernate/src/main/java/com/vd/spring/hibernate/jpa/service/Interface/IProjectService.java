package com.vd.spring.hibernate.jpa.service.Interface;

import com.vd.spring.hibernate.jpa.dto.ProjectDTO;

public interface IProjectService {

    public ProjectDTO save(String name, String description);
    public ProjectDTO update(Long id, String name, String description);
    public ProjectDTO delete(Long id);
}