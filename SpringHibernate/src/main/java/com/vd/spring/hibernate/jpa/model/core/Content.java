package com.vd.spring.hibernate.jpa.model.core;

import javax.persistence.*;
import com.vd.spring.hibernate.jpa.model.Identifiable;

@Entity
@Table(name = "content")
public class Content extends Identifiable {

    private String name;
    private String description;

    public Content() {
        this.name = name;
        this.description = description;
    }

    public Content(String name, String description) {
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