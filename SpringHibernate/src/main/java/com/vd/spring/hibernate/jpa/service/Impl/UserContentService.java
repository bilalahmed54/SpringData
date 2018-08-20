package com.vd.spring.hibernate.jpa.service.Impl;

import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.vd.spring.hibernate.jpa.model.core.User;
import com.vd.spring.hibernate.jpa.model.core.Content;
import org.springframework.beans.factory.annotation.Value;
import com.vd.spring.hibernate.jpa.model.core.ContentUser;
import org.springframework.beans.factory.annotation.Autowired;
import com.vd.spring.hibernate.jpa.dto.UserContent.UserContentDTO;
import com.vd.spring.hibernate.jpa.repository.Interface.IUserRepository;
import com.vd.spring.hibernate.jpa.service.Interface.IUserContentService;
import com.vd.spring.hibernate.jpa.repository.Interface.IContentRepository;
import com.vd.spring.hibernate.jpa.integration.email.SendInBlueEmailService;
import com.vd.spring.hibernate.jpa.repository.Interface.IUserContentRepository;

@Service
public class UserContentService implements IUserContentService {

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IContentRepository iContentRepository;

    @Autowired
    IUserContentRepository iUserContentRepository;

    @Autowired
    SendInBlueEmailService sendInBlueEmailService;

    @Value("${email.subject}")
    private String emailSubject;

    @Value("${email.body}")
    private String emailBody;

    @Override
    public UserContentDTO save(String userIdStr, String videoIdStr, String contentCircleType) {

        User user = null;
        Content content = null;
        UserContentDTO userContentDTO = new UserContentDTO();

        Long userId = Long.parseLong(userIdStr);
        Optional<User> userObj = iUserRepository.findById(userId);

        Long videoId = Long.parseLong(videoIdStr);
        Optional<Content> videoObj = iContentRepository.findById(videoId);

        if (userObj.isPresent() && videoObj.isPresent()) {

            user = userObj.get();
            content = videoObj.get();

            ContentUser contentUser = new ContentUser();

            contentUser.setUser(user);
            contentUser.setContent(content);
            contentUser.setContentCircleType(contentCircleType);

            contentUser.setContentJoiningStatus(0);
            contentUser.setContentEvaluationStatus(0);

            iUserContentRepository.save(contentUser);

            user.addUserContentsList(contentUser);
            iUserRepository.save(user);

            content.addContentUserList(contentUser);
            iContentRepository.save(content);

            String modifiedEmailSubject = emailSubject.replace("{{user}}", user.getName());
            String modifiedEmailBody = emailBody.replace("{{user}}", user.getName());
            modifiedEmailBody = modifiedEmailBody.replace("{{video}}", content.getName());

            ArrayList<String> recipient = new ArrayList<>();
            recipient.add(user.getEmail());
            sendInBlueEmailService.sendEmail(modifiedEmailSubject, modifiedEmailBody, recipient);

            userContentDTO.setStatus(200);
            userContentDTO.setAppErrorCode(200);
            userContentDTO.setMessage("Invitation Sent Successfully.");

        } else {

            userContentDTO.setStatus(400);
            userContentDTO.setAppErrorCode(400);
            userContentDTO.setMessage("Either User or Video not Found.");
        }

        return userContentDTO;
    }
}