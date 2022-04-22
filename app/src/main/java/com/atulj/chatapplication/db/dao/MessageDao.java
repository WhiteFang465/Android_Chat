package com.atulj.chatapplication.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.atulj.chatapplication.db.entity.Message;

import java.util.List;

@Dao
public interface MessageDao {

    @Query("select * from message")
    List<Message> getAllMessages();

    @Query("select chatMessage from message where messageFromUserId=:id")
    List<Message> getMessagesFromUserId(int id);

    @Query("select chatMessage from message where messageToUserId=:id")
    List<Message> getMessagesToUserId(int id);


}
