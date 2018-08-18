package com.vd.spring.hibernate.jpa.model.core;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "content_feedback_question")
public class ContentFeedbackQuestion extends BaseDomainModel {

    @Column(name = "json_body", nullable = false)
    private String jsonBody;

    public ContentFeedbackQuestion() {
    }

    public ContentFeedbackQuestion(String jsonBody) {
        this.jsonBody = jsonBody;
    }

    public String getJsonBody() {
        return jsonBody;
    }

    public void setJsonBody(String jsonBody) {
        this.jsonBody = jsonBody;
    }
}