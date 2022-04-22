package com.atulj.chatapplication.recyclerview;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.R;
import com.atulj.chatapplication.db.entity.Message;
import com.atulj.chatapplication.db.entity.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private final TextView listOfUser;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        listOfUser=itemView.findViewById(R.id.user_list_textView);

        itemView.setOnClickListener(view -> {
            Toast.makeText(itemView.getContext(), "Click Completed", Toast.LENGTH_SHORT).show();

        });
    }
    public void bind(User entity){
        listOfUser.setText(entity.getFirstName());
    }
}
