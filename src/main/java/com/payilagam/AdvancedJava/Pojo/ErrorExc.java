package com.payilagam.AdvancedJava.Pojo;

public class ErrorExc {



    private String Message;
    private int statusCode;
    private long timestamp;

    public ErrorExc(String message, long timestamp, int statusCode) {
        Message = message;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }



}
