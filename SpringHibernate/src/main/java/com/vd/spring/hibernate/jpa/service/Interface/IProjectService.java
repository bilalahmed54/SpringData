package com.vd.spring.hibernate.jpa.service.Interface;

import com.vd.spring.hibernate.jpa.dto.content.ContentListDTO;
import com.vd.spring.hibernate.jpa.dto.project.ProjectDTO;

public interface IProjectService {

    public ProjectDTO delete(Long id);
    public ProjectDTO get(Long id);
    public ProjectDTO save(String name, String description);
    public ProjectDTO update(Long id, String name, String description);
}