package com.vd.spring.hibernate.jpa.model.core;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.vd.spring.hibernate.jpa.model.Identifiable;

@Entity
@Table(name = "project")
public class Project extends Identifiable {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    public Project() {
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}