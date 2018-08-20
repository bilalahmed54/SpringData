package com.vd.spring.hibernate.jpa.dto.content;

import com.vd.spring.hibernate.jpa.model.core.Content;

public class ContentSummaryDTO {

    private long id;
    private String url;
    private String name;
    private String tags;
    private Boolean isPublic;
    private String description;

    public ContentSummaryDTO() {
    }

    public ContentSummaryDTO(long id, String url, String name, String tags, Boolean isPublic, String description) {

        this.id = id;
        this.url = url;
        this.name = name;
        this.tags = tags;
        this.isPublic = isPublic;
        this.description = description;
    }

    public ContentSummaryDTO(Content content) {

        this.id = content.getId();
        this.url = content.getUrl();
        this.name = content.getName();
        this.tags = content.getTags();
        this.isPublic = content.isPublic();
        this.description = content.getDescription();
    }

    public void setContent(Content content) {

        this.id = content.getId();
        this.url = content.getUrl();
        this.name = content.getName();
        this.tags = content.getTags();
        this.isPublic = content.isPublic();
        this.description = content.getDescription();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}