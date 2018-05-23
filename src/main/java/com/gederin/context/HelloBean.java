package com.gederin.context;


public class HelloBean {
    private String message;

    public void sayMessage() {
        System.out.println(message);
    }

    public void setMessage(String message){
        this.message = message;
    }
}
