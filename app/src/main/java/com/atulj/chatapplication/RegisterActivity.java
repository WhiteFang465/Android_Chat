package com.atulj.chatapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import com.atulj.chatapplication.db.AppDatabase;
import com.atulj.chatapplication.db.dao.UserDao;
import com.atulj.chatapplication.db.entity.User;
import com.google.android.material.textfield.TextInputLayout;


public class RegisterActivity extends AppCompatActivity {

    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextInputLayout username = findViewById(R.id.register_username);
        TextInputLayout password = findViewById(R.id.register_password);
        TextInputLayout repeatPassword = findViewById(R.id.register_passwordRepeat);
        TextInputLayout firstName = findViewById(R.id.register_firstName);
        TextInputLayout lastName = findViewById(R.id.register_lastName);

        resources = getResources();

        findViewById(R.id.register_register).setOnClickListener(v -> {
            if (isEmpty(username, password, repeatPassword, firstName, lastName)) {
                return; //End click Event.
            }

            if (!doPasswordMatch(password, repeatPassword)){
                return;
            }

            //Todo: User Already Exist

            User user = new User(getValue(username), getValue(password), getValue(firstName), getValue(lastName));
            UserDao userDao = AppDatabase.getDatabaseInstance(this).getUserDao();

            AppDatabase.databaseWriteExecutor.execute(() -> {
                userDao.insert(user);
                runOnUiThread(() -> Toast.makeText(this, "User created Successfully", Toast.LENGTH_SHORT).show());
                finish();
            });

        });
    }

    private String getValue(@NonNull TextInputLayout view) {
        return view.getEditText().getText().toString();
    }

    private boolean doPasswordMatch(@NonNull TextInputLayout password,@NonNull TextInputLayout repeatPassword) {
        String passwordValue = password.getEditText().getText().toString();
        String passwordRepeatValue = repeatPassword.getEditText().getText().toString();
        if (!passwordValue.equals(passwordRepeatValue)) {
            repeatPassword.setError(resources.getString(R.string.register_passwordDoesNotMatch));
            repeatPassword.setErrorEnabled(true);
            return false;
        }
        repeatPassword.setErrorEnabled(false);
        return true;
    }

    private boolean isEmpty(TextInputLayout... views) {
        boolean foundError = false;

        for (TextInputLayout view : views) {
            String value = view.getEditText().getText().toString();
            if (value.isEmpty()) {
                view.setError(resources.getString(R.string.register_emptyError));
                view.setErrorEnabled(true);
                foundError = true;
            } else {
                view.setErrorEnabled(false);
            }

        }
        return foundError;
    }


}