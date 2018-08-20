package com.vd.spring.hibernate.jpa.model.core;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "project")
public class Project extends BaseDomainModel {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = true, unique = false)
    private String description;

    @OneToMany(mappedBy = "project")
    /*@JoinTable(name = "content", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))*/
    private List<Content> videos;

    public Project() {
        this.videos = new ArrayList<>();
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.videos = new ArrayList<>();
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

    public List<Content> getVideos() {
        return videos;
    }

    public void setVideos(List<Content> videos) {
        this.videos = videos;
    }

    public void addVideo(Content video) {
        this.videos.add(video);
    }
}