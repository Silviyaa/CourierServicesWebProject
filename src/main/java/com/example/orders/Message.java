package com.example.orders;

public class Message {
    private String content;
    private String type;
    public Message(String content, String type){
        this.content = content;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
