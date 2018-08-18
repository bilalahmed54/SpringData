package com.vd.spring.hibernate.jpa.model.core;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "user")
public class User extends BaseDomainModel {

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

    @OneToMany
    @JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<ContentUser> userContentsList;

    public User() {
        this.userContentsList = new ArrayList<>();
    }

    public User(String name, String password, String role, String email, String gender, Date dateOfBirth, String location) {

        this.name = name;
        this.role = role;
        this.email = email;
        this.gender = gender;
        this.location = location;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.userContentsList = new ArrayList<>();
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

    public List<ContentUser> getUserContentsList() {
        return userContentsList;
    }

    public void setUserContentsList(List<ContentUser> userContentsList) {
        this.userContentsList = userContentsList;
    }

    public void addUserContentsList(ContentUser contentUser) {
        userContentsList.add(contentUser);
    }
}