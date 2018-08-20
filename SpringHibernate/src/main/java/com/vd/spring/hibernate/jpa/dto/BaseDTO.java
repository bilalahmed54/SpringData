package com.vd.spring.hibernate.jpa.dto;

public class BaseDTO {

    private int status;
    private String message;
    private int appErrorCode;

    public BaseDTO() {
    }

    public BaseDTO(int status, String message, int appErrorCode) {
        this.status = status;
        this.message = message;
        this.appErrorCode = appErrorCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAppErrorCode() {
        return appErrorCode;
    }

    public void setAppErrorCode(int appErrorCode) {
        this.appErrorCode = appErrorCode;
    }
}