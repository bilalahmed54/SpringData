package com.vd.spring.hibernate.jpa.controller;

import com.vd.spring.hibernate.jpa.dto.ProjectDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vd.spring.hibernate.jpa.service.Interface.IProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    IProjectService iProjectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ProjectDTO save(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "description", required = false) String description) {

        return iProjectService.save(name, description);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ProjectDTO update(@RequestParam(value = "id", required = true) String id,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "description", required = false) String description) {

        Long longId = Long.parseLong(id);
        return iProjectService.update(longId, name, description);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ProjectDTO delete(@RequestParam(value = "id", required = true) String id) {

        Long longId = Long.parseLong(id);
        return iProjectService.delete(longId);
    }
}