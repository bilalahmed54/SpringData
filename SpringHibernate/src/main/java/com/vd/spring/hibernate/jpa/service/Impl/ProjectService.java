package com.vd.spring.hibernate.jpa.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;
import com.vd.spring.hibernate.jpa.model.core.Content;
import com.vd.spring.hibernate.jpa.model.core.Project;
import com.vd.spring.hibernate.jpa.dto.project.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.vd.spring.hibernate.jpa.dto.project.ProjectSummaryDTO;
import com.vd.spring.hibernate.jpa.service.Interface.IProjectService;
import com.vd.spring.hibernate.jpa.repository.Interface.IProjectRepository;
import com.vd.spring.hibernate.jpa.repository.Interface.IContentRepository;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    IContentRepository iContentRepository;

    @Autowired
    IProjectRepository iProjectRepository;

    @Override
    public ProjectDTO save(String name, String description) {

        ProjectDTO projectDTO = new ProjectDTO();

        Project project = iProjectRepository.findFirstByName(name);

        if (project == null) {

            project = new Project(name, description);

            iProjectRepository.save(project);

            projectDTO.setStatus(200);
            projectDTO.setMessage("New Project Created Successfully.");

        } else {

            projectDTO.setStatus(409);
            projectDTO.setAppErrorCode(409);
            projectDTO.setMessage("Project Already Exists.");
        }

        projectDTO.setProject(project);

        return projectDTO;
    }

    @Override
    public ProjectDTO update(Long id, String name, String description) {

        ProjectDTO projectDTO = new ProjectDTO();

        Optional<Project> projectObj = iProjectRepository.findById(id);

        if (projectObj.isPresent()) {

            Project project = projectObj.get();

            if (!StringUtils.isEmpty(name)) {
                project.setName(name);
            }

            if (!StringUtils.isEmpty(description)) {
                project.setDescription(description);
            }

            iProjectRepository.save(project);

            projectDTO.setStatus(200);
            projectDTO.setProject(project);
            projectDTO.setMessage("Project Updated Successfully.");

        } else {

            projectDTO.setStatus(400);
            projectDTO.setAppErrorCode(400);
            projectDTO.setMessage("Project Not Found to Update.");
        }

        return projectDTO;
    }

    @Override
    public ProjectDTO delete(Long id) {

        ProjectDTO projectDTO = new ProjectDTO();

        Optional<Project> projectObj = iProjectRepository.findById(id);

        if (projectObj.isPresent()) {

            Project project = projectObj.get();

            iProjectRepository.delete(project);

            projectDTO.setStatus(200);
            projectDTO.setProject(project);
            projectDTO.setMessage("Project Deleted Successfully.");

        } else {

            projectDTO.setStatus(400);
            projectDTO.setAppErrorCode(400);
            projectDTO.setMessage("Project Not Found to Delete.");
        }

        return projectDTO;
    }

    @Override
    public ProjectDTO get(Long projectId) {

        ProjectDTO projectDTO = new ProjectDTO();
        ProjectSummaryDTO projectSummaryDTO = new ProjectSummaryDTO();

        Optional<Project> projectObj = iProjectRepository.findById(projectId);

        if (projectObj.isPresent()) {

            Project project = projectObj.get();

            List<Content> contentList = iContentRepository.findByProject(project);

            if (contentList.size() != 0) {

                projectDTO.setStatus(200);
                projectDTO.setAppErrorCode(200);
                projectSummaryDTO.populateVideos(contentList);
                projectDTO.setSummaryProject(projectSummaryDTO);
                projectDTO.setMessage("Video Created Successfully.");

            } else {

                projectDTO.setStatus(400);
                projectDTO.setAppErrorCode(400);
                projectDTO.setMessage("No Content Found in the Given Project.");
            }

        } else {

            projectDTO.setStatus(400);
            projectDTO.setAppErrorCode(400);
            projectDTO.setMessage("Project Not Found.");
        }

        return projectDTO;
    }
}