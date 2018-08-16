package com.vd.spring.hibernate.jpa.repository;

import com.vd.spring.hibernate.jpa.model.Content;

public interface IContentRepository{
    public Content saveContent(Content content);
    public Content getContentById(Long id);
}