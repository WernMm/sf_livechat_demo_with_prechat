package com.example.javaapp5;

import android.app.Activity;
import android.app.Application;

public class ServiceSDKApplication extends Application {
    private ChatSessionListener chatSessionListener;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Salesforce Mobile SDK for authentication
        initializeSalesforceSDKManager((Class<? extends Activity>) MainActivity.class);

        chatSessionListener = new ChatSessionListener(getApplicationContext());
    }

    private void initializeSalesforceSDKManager(Class<? extends Activity> activity) {
//        SalesforceSDKManager.initNative(this, activity);
    }

    public ChatSessionListener getChatSessionListener() {
        return chatSessionListener;
    }
}
