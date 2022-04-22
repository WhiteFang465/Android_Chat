package com.atulj.chatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.db.AppDatabase;
import com.atulj.chatapplication.db.dao.UserDao;
import com.atulj.chatapplication.db.entity.User;
import com.atulj.chatapplication.recyclerview.UserAdapter;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;


public class EditActivity extends AppCompatActivity {

    private User user;

    private List<User> users;
    private TextInputLayout username;
    private TextInputLayout password;
    private TextInputLayout firstName;
    private TextInputLayout lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent EditActivityIntent = getIntent();
        if (!EditActivityIntent.hasExtra(LoginActivity.EXTRA_LOGIN_ID)) {
            Log.e("EditActivity on create", "Intent Data" + LoginActivity.EXTRA_LOGIN_ID);
            finish();
        }
        int userId = EditActivityIntent.getIntExtra(LoginActivity.EXTRA_LOGIN_ID, -1);
        UserDao userDao = AppDatabase.getDatabaseInstance(this).getUserDao();
        AppDatabase.databaseWriteExecutor.execute(() -> {
            user = userDao.getUser(userId);
            users =  userDao.getAllUser();

        });


        RecyclerView userList = findViewById(R.id.select_User);
        userList.setLayoutManager(new GridLayoutManager(this, 2));
        userList.setHasFixedSize(false);

        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User("test", "test", "Test ", "User"));
        userArrayList.add(new User("Aj", "Pass", "Atul", "Jairam"));
        Log.e("Users data", " User");
        userArrayList.addAll(users);
        UserAdapter userAdapter = new UserAdapter();
        userAdapter.changeUser(userArrayList);
        userList.setAdapter(userAdapter);




    }


}