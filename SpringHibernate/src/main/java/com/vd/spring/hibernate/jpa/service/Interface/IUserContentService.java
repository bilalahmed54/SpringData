package com.vd.spring.hibernate.jpa.service.Interface;

import com.vd.spring.hibernate.jpa.dto.UserContent.UserContentDTO;

public interface IUserContentService {

    public UserContentDTO save(String userId, String videoId, String contentCircleType);
}