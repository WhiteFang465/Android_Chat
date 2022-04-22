package com.atulj.chatapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.R;
import com.atulj.chatapplication.db.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> userList = new ArrayList<>();
    private Context context;

    public void add(User user){
        userList.add(user);
        notifyDataSetChanged();
    }
    public void remove(User user){
        userList.remove(user);
        notifyDataSetChanged();
    }
    public void changeUser(List<User> users){
        userList=users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        context = parent.getContext();
        return new UserViewHolder(inflateView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.user_list;
    }
}
