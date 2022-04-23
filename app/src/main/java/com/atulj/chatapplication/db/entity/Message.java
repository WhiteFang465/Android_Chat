package com.atulj.chatapplication.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = {"id"}, childColumns = "message_from_user_id", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "message_to_user_id", onDelete = ForeignKey.CASCADE)},
        indices = {@Index(value = {"message_from_user_id", "message_to_user_id"}, unique = true)}
)
public class Message {
    @PrimaryKey(autoGenerate = true)
    private int messageId;
    @ColumnInfo
    private String chatMessage;
    @ColumnInfo(name = "message_from_user_id")
    private int messageFromUserId;
    @ColumnInfo(name = "message_to_user_id")
    private int messageToUserId;

    public Message(String chatMessage, int messageFromUserId, int messageToUserId) {
        this.chatMessage = chatMessage;
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
