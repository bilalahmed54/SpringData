package com.vd.spring.hibernate.jpa.dto.project;

import java.util.List;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.dto.BaseDTO;
import com.vd.spring.hibernate.jpa.model.core.Project;

public class ProjectListDTO extends BaseDTO {

    private List<ProjectSummaryDTO> projects;

    public ProjectListDTO() {
        super();
        this.projects = new ArrayList<>();
    }

    public ProjectListDTO(int status, String message, int appErrorCode) {
        super(status, message, appErrorCode);
        this.projects = new ArrayList<>();
    }

    public List<ProjectSummaryDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectSummaryDTO> projects) {
        this.projects = projects;
    }

    public void populateProjects(List<Project> projects) {
        for (int i = 0; i < projects.size(); i++) {
            ProjectSummaryDTO projectSummaryDTO = new ProjectSummaryDTO(projects.get(i));
            this.projects.add(projectSummaryDTO);
        }
    }

    public void addProject(ProjectSummaryDTO projectSummaryDTO) {
        this.projects.add(projectSummaryDTO);
    }
}