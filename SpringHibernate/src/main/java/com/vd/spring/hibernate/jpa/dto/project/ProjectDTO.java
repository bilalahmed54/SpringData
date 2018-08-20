package com.vd.spring.hibernate.jpa.dto.project;

import com.vd.spring.hibernate.jpa.dto.BaseDTO;
import com.vd.spring.hibernate.jpa.model.core.Project;

public class ProjectDTO extends BaseDTO {

    private ProjectSummaryDTO project;

    public ProjectDTO() {
        super();
    }

    public ProjectDTO(int status, String message, int appErrorCode, Project project) {
        super(status, message, appErrorCode);
        this.project = new ProjectSummaryDTO(project);
    }

    public ProjectSummaryDTO getProject() {
        return project;
    }

    public void setSummaryProject(ProjectSummaryDTO project) {
        this.project = project;
    }

    public void setProject(Project project) {
        this.project = new ProjectSummaryDTO(project);
    }
}