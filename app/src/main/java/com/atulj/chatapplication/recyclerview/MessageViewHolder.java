package com.atulj.chatapplication.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atulj.chatapplication.R;
import com.atulj.chatapplication.db.entity.Message;

public class MessageViewHolder extends RecyclerView.ViewHolder {
private final TextView getMessagesFrom;
private final TextView getChatMessagesTo;

    public MessageViewHolder(@NonNull View itemView) {
        super(itemView);

        getMessagesFrom =itemView.findViewById(R.id.messageListViewItem_message_From);
        getChatMessagesTo=itemView.findViewById(R.id.messageListViewItem_message_To);



    }
    public void bind(Message entity){
        getChatMessagesTo.setText(entity.getChatMessage());
        getMessagesFrom.setText(entity.getChatMessage());
    }
}
