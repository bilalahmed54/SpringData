package com.vd.spring.hibernate.jpa.model;

import javax.persistence.Table;
import javax.persistence.Entity;

@Table
@Entity
public class Student {

    int age;
    String name;
}
