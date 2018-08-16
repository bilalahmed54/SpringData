package com.vd.spring.hibernate.jpa.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.vd.spring.hibernate.jpa.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class ContentRepositoryImp implements IContentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Content saveContent(Content content) {
        getSession().save(content);
        return content;
    }

    @Override
    public Content getContentById(Long id) {
        return (Content) getSession().get(Content.class, id);
    }
}