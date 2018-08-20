package com.vd.spring.hibernate.jpa.controller;

import com.vd.spring.hibernate.jpa.dto.content.ContentDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vd.spring.hibernate.jpa.dto.content.ContentListDTO;
import com.vd.spring.hibernate.jpa.service.Interface.IContentService;

@RestController
@RequestMapping("/video")
public class ContentController {

    @Autowired
    IContentService iContentService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ContentDTO save(@RequestParam(value = "url", required = true) String url,
                               @RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "tags", required = true) String tags,
                               @RequestParam(value = "isPublic", required = true) String isPublic,
                               @RequestParam(value = "description", required = true) String description,
                               @RequestParam(value = "projectName", required = true) String projectName) {

        return iContentService.save(url, name, tags, isPublic, description, projectName);
    }

    @RequestMapping(value = "/public", method = RequestMethod.GET)
    public ContentListDTO getPublicContent() {

        return iContentService.getPublicContents();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ContentListDTO getUserVideos(@RequestParam(value = "userEmail", required = true) String userEmail) {

        return iContentService.getUserContents(userEmail);
    }
}