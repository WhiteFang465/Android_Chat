package com.atulj.chatapplication.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.R;
import com.atulj.chatapplication.db.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    private List<Message> chatMessages = new ArrayList<>();
    private Context context;

    public void add(Message message) {
        chatMessages.add(message);
        notifyDataSetChanged();
    }

    public void remove(Message message) {
        chatMessages.remove(message);
        notifyDataSetChanged();
    }

    public void changeData(List<Message> messages) {
        chatMessages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflaterView = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        context = parent.getContext();
        return new MessageViewHolder(inflaterView);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bind(chatMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.message_list_view_item_from;
    }
}
