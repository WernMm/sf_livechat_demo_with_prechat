package com.example.javaapp5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.javaapp5.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Button chatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.chat_webview);
//
//        WebView webView = (WebView) findViewById(R.id.webview);
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.loadUrl("https://sj-liveagent-developer-edition.ap4.force.com/");

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                launchChatViaSDK();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchChatViaSDK() {
        ChatLauncher chat = new ChatLauncher();
        String customChatId = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        chat.launchChat(this, customChatId);
    }

    private void launchChatViaWebView() {
//        ChatLauncher chat = new ChatLauncher();
//        chat.launchChat(this);
        Exception exp;
        try {
            WebView myWebView = (WebView) findViewById(R.id.webview);
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl("https://sj-liveagent-developer-edition.ap4.force.com/");
        } catch (Exception e) {
            exp = e;
        }

//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sj-liveagent-developer-edition.ap4.force.com/"));
//        startActivity(browserIntent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}