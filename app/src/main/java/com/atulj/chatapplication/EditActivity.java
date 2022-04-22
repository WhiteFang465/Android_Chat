package com.atulj.chatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.atulj.chatapplication.db.AppDatabase;
import com.atulj.chatapplication.db.dao.UserDao;
import com.atulj.chatapplication.db.entity.User;
import com.google.android.material.textfield.TextInputLayout;


public class EditActivity extends AppCompatActivity {

    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        RecyclerView userList= findViewById(R.id.select_User);
        userList.setLayoutManager(new GridLayoutManager(this,3));
        userList.setHasFixedSize(false);



        Intent givenIntent = getIntent();
        if (!givenIntent.hasExtra(LoginActivity.EXTRA_LOGIN_ID)){
            //Error extra wasn't passed
            //For now, let's Log it and Change back to Login Activity.  NOT a good way of handling this issue
            //Bad: Because user has no idea why.
            Log.e("EditActivity_onCreate", "Login Id not provided in Intent with Extra: " + LoginActivity.EXTRA_LOGIN_ID);
            finish();
        }


        int userId = givenIntent.getIntExtra(LoginActivity.EXTRA_LOGIN_ID, -1);
        UserDao userDao = AppDatabase.getDatabaseInstance(this).getUserDao();

        AppDatabase.databaseWriteExecutor.execute(() -> {
            user = userDao.getUser(userId);
//
        });

//
    }




}