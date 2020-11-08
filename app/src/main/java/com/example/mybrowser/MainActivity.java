package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.R.menu;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webview;
    EditText txtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.view);
        txtAddress = findViewById(R.id.textAddress);
        if((getIntent() != null) && getIntent().getData() != null){
            txtAddress.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());


        }


        Button btnGo = findViewById(R.id.button);

        webview.setWebViewClient(new WebViewClient());
        btnGo.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                webview.loadUrl("http://" +txtAddress.getText()  );

            }

        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


}