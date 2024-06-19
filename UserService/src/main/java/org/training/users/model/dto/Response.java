package org.training.users.model.dto;


public class Response {

    private String responseCode;

    private String message;

    public Response(String responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
