package com.vd.spring.hibernate.jpa.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vd.spring.hibernate.jpa.dto.UserContent.UserContentDTO;
import com.vd.spring.hibernate.jpa.service.Interface.IUserContentService;

@RestController
@RequestMapping("/UserContent")
public class UserContentController {

    @Autowired
    IUserContentService iUserContentService;

    @RequestMapping(value = "/invite", method = RequestMethod.POST)
    public UserContentDTO inviteUser(@RequestParam(value = "userId", required = true) String userId,
                                     @RequestParam(value = "contentId", required = false) String contentId,
                                     @RequestParam(value = "type", required = false) String circleType) {

        return iUserContentService.save(userId, contentId, circleType);
    }
}