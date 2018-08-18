package com.vd.spring.hibernate.jpa.model.core;

import java.util.List;
import javax.persistence.*;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "content_user")
public class ContentUser extends BaseDomainModel {

    @OneToMany
    @JoinTable(name = "content_feedback_response", joinColumns = @JoinColumn(name = "id")
            , inverseJoinColumns = @JoinColumn(name = "content_user_id"))
    private List<ContentFeedbackResponse> contentFeedbackResponse;

    public ContentUser() {
    }

    public List<ContentFeedbackResponse> getContentFeedbackResponses() {
        return contentFeedbackResponse;
    }

    public void setContentFeedbackResponses(List<ContentFeedbackResponse> contentFeedbackResponse) {
        this.contentFeedbackResponse = contentFeedbackResponse;
    }

    public void addContentFeedbackResponses(ContentFeedbackResponse contentFeedbackResponse) {
        this.contentFeedbackResponse.add(contentFeedbackResponse);
    }
}