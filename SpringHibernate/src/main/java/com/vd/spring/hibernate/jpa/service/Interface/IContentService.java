package com.vd.spring.hibernate.jpa.service.Interface;

import com.vd.spring.hibernate.jpa.dto.content.ContentDTO;
import com.vd.spring.hibernate.jpa.dto.content.ContentListDTO;
import com.vd.spring.hibernate.jpa.dto.content.ContentSummaryDTO;

public interface IContentService {

    public ContentListDTO getPublicContents();
    public ContentListDTO getUserContents(String userEmail);
    public ContentDTO save(String url, String name, String tags, String isPublic, String description, String projectName);
}