package com.vd.spring.hibernate.jpa.model.core;

import javax.persistence.Table;
import javax.persistence.Entity;
import com.vd.spring.hibernate.jpa.model.BaseDomainModel;

@Entity
@Table(name = "real_time_video_feedback_evaluation")
public class RealTimeVideoFeedbackEvaluation extends BaseDomainModel {

    public RealTimeVideoFeedbackEvaluation() {
    }

}