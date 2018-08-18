package com.vd.spring.hibernate.jpa.model.core;

import java.util.List;
import javax.persistence.*;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "content_user")
public class ContentUser extends BaseDomainModel {

    @Column(name = "content_evaluation_status", nullable = false)
    private int contentEvaluationStatus;

    @Column(name = "content_circle_type", nullable = false)
    private String contentCircleType;

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
        this.contentFeedbackResponseList = new ArrayList<>();
    }

    public ContentUser(int contentEvaluationStatus, String contentCircleType) {
        this.contentCircleType = contentCircleType;
        this.contentEvaluationStatus = contentEvaluationStatus;
        this.contentFeedbackResponseList = new ArrayList<>();
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

    public String getContentCircleType() {
        return contentCircleType;
    }

    public void setContentCircleType(String contentCircleType) {
        this.contentCircleType = contentCircleType;
    }

    public int getContentEvaluationStatus() {
        return contentEvaluationStatus;
    }

    public void setContentEvaluationStatus(int contentEvaluationStatus) {
        this.contentEvaluationStatus = contentEvaluationStatus;
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