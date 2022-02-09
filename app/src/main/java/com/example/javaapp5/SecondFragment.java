package com.example.javaapp5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.javaapp5.databinding.FragmentSecondBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

//        binding = FragmentSecondBinding.inflate(inflater, container, false);
//        return binding.getRoot();

        View v= inflater.inflate(R.layout.fragment_second, container, false);
        WebView mWebView = (WebView) v.findViewById(R.id.webview);

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setSaveFormData(false);
        webSettings.setDomStorageEnabled(true);
//        webSettings.setBuiltInZoomControls(false);
//        webSettings.setSupportZoom(false);
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setUseWideViewPort(false);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
//                String prechatData = "{\"appId\":\"appId_1234\", \"customChatId\":\""+customChatId+"\"}";
                String prechatData = "{\"appId\":\"LINEMAN_Android\", \"useCase\":\"TEST\", \"userId\":\"SJ\"}";
                String callJS = "javascript:setPrechatData("+prechatData+")";
                view.loadUrl(callJS);
            }
        });

        String customChatId = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        String customChatId = "sj0001";
        mWebView.addJavascriptInterface(new JsWebInterface(this.getActivity(), customChatId, this.getActivity(), v), "MobileFunction");
        mWebView.loadUrl("https://dev-lmwn.cs5.force.com/prechat?customChatId="+customChatId);
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}