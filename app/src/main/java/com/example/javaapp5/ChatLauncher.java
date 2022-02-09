package com.example.javaapp5;

import android.content.Context;
import com.salesforce.android.chat.core.ChatConfiguration;
import com.salesforce.android.chat.core.model.ChatUserData;
import com.salesforce.android.chat.ui.ChatUI;
import com.salesforce.android.chat.ui.ChatUIClient;
import com.salesforce.android.chat.ui.ChatUIConfiguration;
import com.salesforce.android.service.common.utilities.control.Async;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;

public class ChatLauncher {

    private Context context;
    public static final String ORG_ID = "00DO000000544EH";
    public static final String DEPLOYMENT_ID = "572O000000000bk";
    public static final String BUTTON_ID = "573O000000000ey";
    public static final String LIVE_AGENT_POD = "d.la1-c1cs-ukb.salesforceliveagent.com";
    // d.la1-c2-hnd.salesforceliveagent.com/chat
    // d.la.salesforce.com

    public void launchChat(final Context context, String customChatId) {
        ChatConfiguration chatConfiguration = null;
        this.context = context;
        try {
            ChatConfiguration.Builder chatConfigBuilder = this.initChatConfigurationBuild(customChatId);
            chatConfiguration = chatConfigBuilder.build();
        } catch(Exception e) {
//            ...
        }
        ChatUIConfiguration.Builder chatUIConfigurationBuilder = new ChatUIConfiguration.Builder();
        chatUIConfigurationBuilder.disablePreChatView(true);
        chatUIConfigurationBuilder.defaultToMinimized(false);
        chatUIConfigurationBuilder.chatConfiguration(chatConfiguration);
        ChatUI.configure(chatUIConfigurationBuilder.build())
                .createClient(context)
                .onResult(new Async.ResultHandler<ChatUIClient>() {
                    @Override public void handleResult (Async<?> operation, ChatUIClient chatUIClient) {
                        ChatSessionStateListener sessionStateListener = new ChatSessionStateListener();
                        chatUIClient.addSessionStateListener(sessionStateListener);
                        chatUIClient.startChatSession((FragmentActivity)context);
                    }
                });
    }

    public ChatConfiguration.Builder initChatConfigurationBuild(String customChatId) {
        ChatConfiguration.Builder chatConfigBuilder = new ChatConfiguration.Builder(ORG_ID, BUTTON_ID, DEPLOYMENT_ID, LIVE_AGENT_POD);
        ChatUserData customChatIdUserData = new ChatUserData(
                "CustomChatId",
                customChatId, // unique value to identify chat for mapping prechat data with chat session
                false,
                "CustomChatId__c");
        chatConfigBuilder.chatUserData(customChatIdUserData);
        return chatConfigBuilder;
    }
}
