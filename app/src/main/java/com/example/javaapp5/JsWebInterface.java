package com.example.javaapp5;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class JsWebInterface {
    Context mContext;
    String customChatId;
    Activity mActivity;
    View mView;

    JsWebInterface(Context c, String chatId, Activity a, View v) {
        customChatId = chatId;
        mContext = c;
        mView = v;
        mActivity = a;
    }

    @JavascriptInterface
    public void launchChat() {
        try {
            Log.i("JavascriptInterface", "launchChat");
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mView.setVisibility(View.GONE);
                    ChatLauncher chat = new ChatLauncher();
                    chat.launchChat(mContext, customChatId);
                }
            });

        } catch (Exception e) {
            Log.e("launchChat Exception", e.getMessage());
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @JavascriptInterface
    public void endPrechat() {
        Log.i("JavascriptInterface", "endPrechat");
        Toast.makeText(mContext, "endPrechat", Toast.LENGTH_SHORT).show();
    }


    @JavascriptInterface
    public void endPostchat() {
        Log.i("JavascriptInterface", "endPostchat");
        Toast.makeText(mContext, "endPostchat", Toast.LENGTH_SHORT).show();
    }
}
