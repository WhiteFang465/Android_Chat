package com.atulj.chatapplication.db.entity;

import java.util.Date;

public class Message {
    public Message(String message, Date created, int messageFromUserId, int messageToUserId) {
        Message = message;
        this.created = created;
        this.messageFromUserId = messageFromUserId;
        this.messageToUserId = messageToUserId;
    }

    private int messageId;
private String Message;
private Date created;
private int messageFromUserId;
private int messageToUserId;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMessageFromUserId() {
        return messageFromUserId;
    }

    public void setMessageFromUserId(int messageFromUserId) {
        this.messageFromUserId = messageFromUserId;
    }

    public int getMessageToUserId() {
        return messageToUserId;
    }

    public void setMessageToUserId(int messageToUserId) {
        this.messageToUserId = messageToUserId;
    }
}
