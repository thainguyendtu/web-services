package com.fpt.webservicesudemy.helloworld;

public class HelloWorldBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorldBean() {
    }

    public HelloWorldBean(String message) {
        this.message = message;
    }
}
