package com.atulj.chatapplication.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Message {
    @PrimaryKey
    private int messageId;
    @ColumnInfo
    private String chatMessage;
    @ColumnInfo
    private Date created;
    @ColumnInfo
    private int messageFromUserId;
    @ColumnInfo
    private int messageToUserId;

    public Message(String chatMessage, Date created, int messageFromUserId, int messageToUserId) {
        this.chatMessage = chatMessage;
        this.created = created;
        this.messageFromUserId = messageFromUserId;
        this.messageToUserId = messageToUserId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
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
