package com.myproject.sachinpatel.jobsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;


import com.example.sachinpatel.jobsearch.R;

public class PortalPage extends AppCompatActivity {

    ImageButton indeed_button;
    ImageButton monster_button;
    ImageButton workopolis_button;
    ImageButton ziprecruiter_button;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal_page);
        indeed_button = (ImageButton)findViewById(R.id.indeed);
        monster_button = (ImageButton)findViewById(R.id.monster);
        workopolis_button = (ImageButton)findViewById(R.id.workopolis);
        ziprecruiter_button = (ImageButton)findViewById(R.id.ziprecruiter);
        final int myColor = getResources().getColor(R.color.yellow);
        webView = (WebView)findViewById(R.id.webview);

        Intent intent = getIntent();
        final String Position = intent.getStringExtra("position");
        final String Location_City = intent.getStringExtra("city");
        final String Location_Province = intent.getStringExtra("province");

        //Log.d("details", Position);


        indeed_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("Indeed", "indeed click thayu");
                String uri = "https://ca.indeed.com/jobs?q="+Position+"&l="+Location_City+"%2C+"+Location_Province;
                Intent intent1 = new Intent(PortalPage.this, JobListWebView.class);
                intent1.putExtra("url", uri);
                startActivity(intent1);
//                webView.setWebViewClient(new WebViewClient());
//                webView.loadUrl("https://ca.indeed.com/jobs?q="+Position+"&l="+Location_City+"%2C+"+Location_Province);
//                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
//                CustomTabsIntent customTabsIntent = builder.build();
//                customTabsIntent.launchUrl(PortalPage.this, uri);
//
//                builder.setToolbarColor(myColor);
            }
        });

        monster_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Uri uri = Uri.parse("https://www.monster.ca/jobs/search/?q="+Position+"&where="+Location_City+"__2C-"+Location_Province);
                String uri = "https://www.monster.ca/jobs/search/?q="+Position+"&where="+Location_City+"__2C-"+Location_Province;
                Intent intent1 = new Intent(PortalPage.this, JobListWebView.class);
                intent1.putExtra("url", uri);
                startActivity(intent1);
            }
        });

        workopolis_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String uri = "https://www.workopolis.com/jobsearch/find-jobs?ak="+Position+"&l="+Location_City+"%2C+"+Location_Province;
                Intent intent1 = new Intent(PortalPage.this, JobListWebView.class);
                intent1.putExtra("url", uri);
                startActivity(intent1);
            }
        });

        ziprecruiter_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String uri = "https://www.ziprecruiter.com/candidate/search?search="+Position+"&location="+Location_City+"%2C+"+Location_Province;
                Intent intent1 = new Intent(PortalPage.this, JobListWebView.class);
                intent1.putExtra("url", uri);
                startActivity(intent1);
            }
        });

    }
}
