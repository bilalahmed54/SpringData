package com.vd.spring.hibernate.jpa.controller;

import com.vd.spring.hibernate.jpa.model.core.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vd.spring.hibernate.jpa.repository.Interface.IContentRepository;

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

        newContent = iContentRepository.save(newContent);

        return "New Content Added: " + newContent.getId();
    }

    @RequestMapping("/getContent")
    public Content getContent(@RequestParam("contentId") long contentId) {

        Content content = iContentRepository.findById(contentId).get();
        return content;
    }
}