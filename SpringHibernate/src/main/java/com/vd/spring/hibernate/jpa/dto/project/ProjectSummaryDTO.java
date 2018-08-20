package com.vd.spring.hibernate.jpa.dto.project;

import java.util.List;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.model.core.Content;
import com.vd.spring.hibernate.jpa.model.core.Project;
import com.vd.spring.hibernate.jpa.dto.content.ContentSummaryDTO;

public class ProjectSummaryDTO {

    private long id;
    private String name;
    private String description;
    private List<ContentSummaryDTO> videos;

    public ProjectSummaryDTO() {
        this.videos = new ArrayList<>();
    }

    public ProjectSummaryDTO(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.videos = new ArrayList<>();
    }

    public ProjectSummaryDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
        this.videos = new ArrayList<>();
    }

    public void setProject(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<ContentSummaryDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<ContentSummaryDTO> videos) {
        this.videos = videos;
    }

    public void populateVideos(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            ContentSummaryDTO contentSummaryDTO = new ContentSummaryDTO(contents.get(i));
            this.videos.add(contentSummaryDTO);
        }
    }
}