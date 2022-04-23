package com.atulj.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.db.AppDatabase;
import com.atulj.chatapplication.db.dao.MessageDao;
import com.atulj.chatapplication.db.entity.Message;
import com.atulj.chatapplication.recyclerview.MessageAdapter;
import com.atulj.chatapplication.recyclerview.UserViewHolder;

import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private int userId;
    private List<Message> chatMessages;
    private List<Message> chatMessageFrom;
    private List<Message> getChatMessageTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent getData = getIntent();
        if (!getData.hasExtra(UserViewHolder.EXTRA_USER_ID)) {
            return;
        }
        RecyclerView chatList = findViewById(R.id.chat_activity_RecyclerView);

        chatList.setLayoutManager(new LinearLayoutManager(this));
        chatList.setHasFixedSize(false);

        if (getData.hasExtra(UserViewHolder.EXTRA_USER_ID)) {
            Toast.makeText(this, "UserId " + getData.getIntExtra(UserViewHolder.EXTRA_USER_ID, -1), Toast.LENGTH_SHORT).show();
        }
        userId = getData.getIntExtra(UserViewHolder.EXTRA_USER_ID, -1);
        chatMessages.add(new Message("Hi",0,1));
//        MessageDao chatMessageDao = AppDatabase.getDatabaseInstance(this).getMessageDao();
//        AppDatabase.databaseWriteExecutor.execute(() -> {
//            chatMessageFrom = chatMessageDao.getMessagesFromUserId(userId);
//            getChatMessageTo = chatMessageDao.getMessagesToUserId(userId);
//        });
        MessageAdapter messageAdapter=new MessageAdapter();
        messageAdapter.changeData(getChatMessageTo);

    }
}