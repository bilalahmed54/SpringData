package com.vd.spring.hibernate.jpa.dto.content;

import java.util.List;
import java.util.ArrayList;
import com.vd.spring.hibernate.jpa.dto.BaseDTO;
import com.vd.spring.hibernate.jpa.model.core.Content;

public class ContentListDTO extends BaseDTO {

    private List<ContentSummaryDTO> contents;

    public ContentListDTO() {
        super();
        this.contents = new ArrayList<>();
    }

    public ContentListDTO(int status, String message, int appErrorCode) {
        super(status, message, appErrorCode);
        this.contents = new ArrayList<>();
    }

    public List<ContentSummaryDTO> getContents() {
        return contents;
    }

    public void setContents(List<ContentSummaryDTO> contentSummaryDTOList) {
        this.contents = contentSummaryDTOList;
    }

    public void populateContents(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            ContentSummaryDTO contentSummaryDTO = new ContentSummaryDTO(contents.get(i));
            this.contents.add(contentSummaryDTO);
        }
    }

    public void addContent(ContentSummaryDTO contentSummaryDTO) {
        this.contents.add(contentSummaryDTO);
    }
}