package com.atulj.chatapplication.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.atulj.chatapplication.db.entity.Message;

import java.util.List;

@Dao
public interface MessageDao {

    @Query("select * from message")
    List<Message> getAllMessages();

//    @Query("select chatMessage from message where message_from_user_id=(select * from user where id=:id)")
//    List<Message> getMessagesFromUserId(int id);
//
//    @Query("select chatMessage from message where message_to_user_id=(select * from user where id=:id)")
//    List<Message> getMessagesToUserId(int id);


}
