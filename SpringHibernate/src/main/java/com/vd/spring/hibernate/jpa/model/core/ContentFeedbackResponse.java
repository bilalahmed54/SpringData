package com.vd.spring.hibernate.jpa.model.core;

import javax.persistence.*;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "content_feedback_response")
public class ContentFeedbackResponse extends BaseDomainModel {

    @Column(name = "response", nullable = false)
    private String response;

    @ManyToOne
    @JoinColumn(name = "content_user_id")
    private  ContentUser contentUser;

    @OneToOne
    private ContentFeedbackQuestion contentFeedbackQuestion;

    public ContentFeedbackResponse() {
    }

    public ContentFeedbackResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ContentFeedbackQuestion getContentFeedbackQuestion() {
        return contentFeedbackQuestion;
    }

    public void addContentFeedbackQuestion(ContentFeedbackQuestion contentFeedbackQuestion) {
        this.contentFeedbackQuestion = contentFeedbackQuestion;
    }
}