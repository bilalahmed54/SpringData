package com.vd.spring.hibernate.jpa.dto;

import com.vd.spring.hibernate.jpa.model.core.User;

public class UserContentDTO {

    private int status;
    private String jwt;
    private String message;
    private int appErrorCode;

    private User user;

    public UserContentDTO() {
    }

    public UserContentDTO(int status, String message, int appErrorCode, User user) {
        this.status = status;
        this.message = message;
        this.appErrorCode = appErrorCode;
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAppErrorCode() {
        return appErrorCode;
    }

    public void setAppErrorCode(int appErrorCode) {
        this.appErrorCode = appErrorCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}