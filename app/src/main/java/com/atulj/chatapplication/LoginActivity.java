package com.atulj.chatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.atulj.chatapplication.db.AppDatabase;
import com.atulj.chatapplication.db.dao.UserDao;
import com.atulj.chatapplication.db.entity.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;



public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_LOGIN_ID = "LoginId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputLayout username = findViewById(R.id.login_username);
        TextInputLayout password = findViewById(R.id.login_password);

        findViewById(R.id.login_register).setOnClickListener(v -> {
            Intent registerIntent = new Intent(this,RegisterActivity.class);
            startActivity(registerIntent);
        });

        UserDao userDao = AppDatabase.getDatabaseInstance(this).getUserDao();
        Resources resources = getResources();

        findViewById(R.id.login_login).setOnClickListener(v -> {
            String usernameValue = username.getEditText().getText().toString();
            String passwordValue = password.getEditText().getText().toString();

            AppDatabase.databaseWriteExecutor.execute(() -> {
                if (!userDao.exist(usernameValue)) {
                    runOnUiThread(() -> username.setError(resources.getString(R.string.login_invalidUsername)));
                    return;
                } else {
                    runOnUiThread(() -> username.setError(null));
                }

                User user = userDao.validate(usernameValue, passwordValue);

                if (user == null) {
                    runOnUiThread(() -> password.setError(resources.getString(R.string.login_invalidPassword)));
                    return;
                } else {
                    runOnUiThread(() -> password.setError(null));
                }

                Intent editIntent = new Intent(this, EditActivity.class);
                editIntent.putExtra(EXTRA_LOGIN_ID, user.getId());
                startActivity(editIntent);

            });

        });
    }
}