package com.vd.spring.hibernate.jpa.model.core;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;

import com.vd.spring.hibernate.jpa.model.Identifiable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "user")
public class User extends Identifiable {

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Column(name = "role", nullable = false, unique = false)
    private String role;

    @Column(name = "email", nullable = false, unique = false)
    private String email;

    @Column(name = "gender", nullable = false, unique = false)
    private String gender;

    @Column(name = "date_of_birth", nullable = false, unique = false)
    private Date dateOfBirth;

    @Column(name = "location", nullable = false, unique = false)
    private String location;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    public User() {
    }

    public User(String name, String password, String role, String email, String gender, Date dateOfBirth, String location) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}