package com.vd.spring.hibernate.jpa.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vd.spring.hibernate.jpa.model.core.Project;
import com.vd.spring.hibernate.jpa.model.core.Content;
import com.vd.spring.hibernate.jpa.dto.content.ContentDTO;
import com.vd.spring.hibernate.jpa.dto.content.ContentListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.vd.spring.hibernate.jpa.service.Interface.IContentService;
import com.vd.spring.hibernate.jpa.repository.Interface.IContentRepository;
import com.vd.spring.hibernate.jpa.repository.Interface.IProjectRepository;

@Service
public class ContentService implements IContentService {

    @Autowired
    IContentRepository iContentRepository;

    @Autowired
    IProjectRepository iProjectRepository;

    @Override
    public ContentListDTO getPublicContents() {

        ContentListDTO contentListDTO = new ContentListDTO();

        List<Content> contentList = iContentRepository.publicContents();

        if (contentList.size() != 0) {

            contentListDTO.setStatus(200);
            contentListDTO.setAppErrorCode(200);
            contentListDTO.populateContents(contentList);
            contentListDTO.setMessage("Public Contents List Fetched Successfully.");

        } else {

            contentListDTO.setStatus(400);
            contentListDTO.setAppErrorCode(400);
            contentListDTO.setMessage("No Public Content Found.");
        }

        return contentListDTO;
    }

    @Override
    public ContentDTO save(String url, String name, String tags, String isPublicStr, String description, String projectName) {

        ContentDTO contentDTO = new ContentDTO();

        Content content = iContentRepository.findFirstByName(name);

        if (content == null) {

            boolean isPublic = isPublicStr.equalsIgnoreCase("true");

            content = new Content(url, name, tags, isPublic, description);

            Project project = iProjectRepository.findFirstByName(projectName);

            if (project == null) {

                contentDTO.setStatus(400);
                contentDTO.setAppErrorCode(400);
                contentDTO.setMessage("Project Not Found to Add in Content.");

            } else {

                content.setProject(project);
                iContentRepository.save(content);

                project.addVideo(content);
                iProjectRepository.save(project);

                contentDTO.setStatus(200);
                contentDTO.setContent(content);
                contentDTO.setAppErrorCode(200);
                contentDTO.setMessage("Video Created Successfully.");
            }

        } else {

            contentDTO.setStatus(409);
            contentDTO.setAppErrorCode(409);
            contentDTO.setMessage("Video Already Exist.");
        }

        return contentDTO;
    }

    @Override
    public ContentListDTO getUserContents(String userEmail) {
        return null;
    }
}