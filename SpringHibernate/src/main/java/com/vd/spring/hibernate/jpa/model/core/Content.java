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
    private boolean isPublic;
    private String description;

    @OneToMany
    @JoinTable(name = "content_user", joinColumns = @JoinColumn(name = "content_user_id"),
            inverseJoinColumns = @JoinColumn(name = "content_id"))
    private List<ContentUser> contentUserList;

    public Content() {
        this.contentUserList = new ArrayList<>();
    }

    public Content(String name, String description) {
        this.name = name;
        this.description = description;
        this.contentUserList = new ArrayList<>();
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