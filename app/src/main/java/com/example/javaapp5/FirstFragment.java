package com.example.javaapp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.javaapp5.databinding.FragmentFirstBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                launchChatViaWebView(view);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    private void launchChat() {
        ChatLauncher chat = new ChatLauncher();
        String customChatId = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        chat.launchChat(this.getActivity(), customChatId);
    }

    private void launchChatViaWebView(View v) {
//        ChatLauncher chat = new ChatLauncher();
//        chat.launchChat(this);
        Exception exp;
        try {
            WebView myWebView = (WebView) v.findViewById(R.id.webview);
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            String customChatId = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            myWebView.loadUrl("https://dev-lmwn.cs5.force.com/prechat?customChatId="+customChatId);
        } catch (Exception e) {
            exp = e;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}