package com.example.javaapp5;

import android.content.Context;
import android.widget.Toast;

import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;

public class ChatSessionListener implements SessionStateListener {
    private Context context;

    public ChatSessionListener(Context context) {
        this.context = context;
    }

    @Override
    public void onSessionStateChange(ChatSessionState chatSessionState) {
    }

    @Override
    public void onSessionEnded(ChatEndReason chatEndReason) {
        showToast(chatEndReason.toString());

    }

    private void showToast(String reason) {
        Toast.makeText(context,"Chat state:" + reason, Toast.LENGTH_SHORT).show();
    }

}
