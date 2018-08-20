package com.vd.spring.hibernate.jpa.dto.content;

import com.vd.spring.hibernate.jpa.dto.BaseDTO;
import com.vd.spring.hibernate.jpa.model.core.Content;

public class ContentDTO extends BaseDTO {

    private ContentSummaryDTO content;

    public ContentDTO() {
        super();
    }

    public ContentDTO(int status, String message, int appErrorCode, Content content) {
        super(status, message, appErrorCode);
        this.content = new ContentSummaryDTO(content);
    }

    public ContentSummaryDTO getContent() {
        return content;
    }

    public void setSummaryContent(ContentSummaryDTO content) {
        this.content = content;
    }

    public void setContent(Content content) {
        this.content = new ContentSummaryDTO(content);
    }
}