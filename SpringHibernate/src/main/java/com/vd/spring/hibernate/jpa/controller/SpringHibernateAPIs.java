package com.vd.spring.hibernate.jpa.controller;

import com.vd.spring.hibernate.jpa.model.Content;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vd.spring.hibernate.jpa.repository.IContentRepository;

@RestController
public class SpringHibernateAPIs {

    @Autowired
    IContentRepository iContentRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello World - Spring Hibernate JPA";
    }

    @RequestMapping("/addContent")
    public String addContent() {

        Content newContent = new Content();

        newContent.setName("BAY");
        newContent.setDescription("Bilal Ahmed Yaseen");

        newContent = iContentRepository.saveContent(newContent);

        return "New Content Added: " + newContent.getId();
    }

    @RequestMapping("/getContent")
    public Content getContent(@PathVariable("contentId") long contentId) {

        Content content = iContentRepository.getContentById(contentId);
        return content;
    }

}