package com.vd.spring.hibernate.jpa.repository.Interface;

import com.vd.spring.hibernate.jpa.model.core.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContentRepository extends JpaRepository<Content, Long> {

}