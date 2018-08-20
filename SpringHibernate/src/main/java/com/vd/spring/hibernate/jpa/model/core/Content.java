package com.vd.spring.hibernate.jpa.model.core;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "content")
public class Content extends BaseDomainModel {

    private String url;
    private String name;
    private String tags;
    private Boolean isPublic;
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "content")
    /*@JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "content_id"))*/
    private List<ContentUser> contentUserList;

    public Content() {
        this.isPublic = false;
        this.contentUserList = new ArrayList<>();
    }

    public Content(String name, String description) {
        this.name = name;
        this.isPublic = false;
        this.description = description;
        this.contentUserList = new ArrayList<>();
    }

    public Content(String url, String name, String tags, boolean isPublic, String description) {
        this.url = url;
        this.name = name;
        this.tags = tags;
        this.isPublic = isPublic;
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ContentUser> getContentUserList() {
        return contentUserList;
    }

    public void setContentUserList(List<ContentUser> contentUserList) {
        this.contentUserList = contentUserList;
    }

    public void addContentUserList(ContentUser contentUserList) {
        this.contentUserList.add(contentUserList);
    }
}