package com.vd.spring.hibernate.jpa.model.core;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "content_user")
public class ContentUser extends BaseDomainModel {

    @Column(name = "content_evaluaton_status", nullable = false)
    int contentEvaluatonStatus;

    @Column(name = "content_circle_type", nullable = false)
    String contentCircleType;

    @Column(name = "video_feedback_url", nullable = true)
    private String videoFeedbackUrl;

    @OneToOne
    private RealTimeVideoFeedbackEvaluation realTimeVideoFeedbackEvaluationResult;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @OneToMany
    @JoinTable(name = "content_feedback_response", joinColumns = @JoinColumn(name = "id")
            , inverseJoinColumns = @JoinColumn(name = "content_user_id"))
    private List<ContentFeedbackResponse> contentFeedbackResponseList;

    public ContentUser() {
        contentFeedbackResponseList = new ArrayList<>();
    }

    public String getVideoFeedbackUrl() {
        return videoFeedbackUrl;
    }

    public void setVideoFeedbackUrl(String videoFeedbackUrl) {
        this.videoFeedbackUrl = videoFeedbackUrl;
    }

    public RealTimeVideoFeedbackEvaluation getRealTimeVideoFeedbackEvaluationResult() {
        return realTimeVideoFeedbackEvaluationResult;
    }

    public void setRealTimeVideoFeedbackEvaluationResult(RealTimeVideoFeedbackEvaluation realTimeVideoFeedbackEvaluationResult) {
        this.realTimeVideoFeedbackEvaluationResult = realTimeVideoFeedbackEvaluationResult;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public List<ContentFeedbackResponse> getContentFeedbackResponseList() {
        return contentFeedbackResponseList;
    }

    public void setContentFeedbackResponseList(List<ContentFeedbackResponse> contentFeedbackResponseList) {
        this.contentFeedbackResponseList = contentFeedbackResponseList;
    }

    public void addContentFeedbackResponseList(ContentFeedbackResponse contentFeedbackResponse) {
        this.contentFeedbackResponseList.add(contentFeedbackResponse);
    }
}