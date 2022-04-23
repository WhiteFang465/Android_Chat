package com.atulj.chatapplication.recyclerview;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.ChatActivity;
import com.atulj.chatapplication.R;
import com.atulj.chatapplication.db.entity.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private final TextView listOfUser;
    private User user;
    public static final String EXTRA_USER_ID="UserId";


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        listOfUser = itemView.findViewById(R.id.user_list_textView);

        itemView.setOnClickListener(v -> {
            Toast.makeText(itemView.getContext(), "User selected", Toast.LENGTH_SHORT).show();
            Intent goToChat = new Intent(v.getContext(), ChatActivity.class);
            Log.e("User Id","User Id "+user.getUsername());
            goToChat.putExtra(EXTRA_USER_ID,user.getId());
            v.getContext().startActivity(goToChat);
        });
    }

    public void bind(User entity) {
        this.user = entity;

        listOfUser.setText(entity.getFirstName() + " " + entity.getLastName());
    }
}
