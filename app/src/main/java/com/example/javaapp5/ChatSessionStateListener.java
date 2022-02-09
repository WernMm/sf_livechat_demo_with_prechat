package com.example.javaapp5;

import android.util.Log;
import android.widget.Toast;

import com.salesforce.android.chat.core.SessionStateListener;
import com.salesforce.android.chat.core.model.ChatEndReason;
import com.salesforce.android.chat.core.model.ChatSessionState;

import java.util.logging.ConsoleHandler;

public class ChatSessionStateListener implements SessionStateListener {
//    Boolean alreadyChatWithAgent = false;


    @Override public void onSessionStateChange (ChatSessionState state) {
//        if(state == ChatSessionState.Connected) {
//            this.alreadyChatWithAgent = true;
//        }
//        Log.w("onSessionStateChange", state.toString());
    }

    @Override public void onSessionEnded(ChatEndReason endReason) {
//        if(this.alreadyChatWithAgent) {
//            if (endReason == ChatEndReason.EndedByAgent) {
//                // TODO: WebView to Show PostChat UI
//            } else if(endReason == ChatEndReason.EndedByClient) {
//                // TODO: WebView to Show PostChat UI
//            }
//        }
    }



}