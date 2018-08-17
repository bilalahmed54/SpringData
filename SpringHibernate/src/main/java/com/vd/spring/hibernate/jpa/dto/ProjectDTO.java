package com.vd.spring.hibernate.jpa.dto;

import com.vd.spring.hibernate.jpa.model.core.Project;

public class ProjectDTO {

    private int status;
    private String message;
    private int appErrorCode;

    private Project project;

    public ProjectDTO() {
    }

    public ProjectDTO(int status, String message, int appErrorCode, Project project) {
        this.status = status;
        this.message = message;
        this.appErrorCode = appErrorCode;
        this.project = project;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}