package com.example.event;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Map extends Activity {
	    //https://maps.google.com/?ll=18.36567,83.45897&spn=29.301969,56.513672&t=h&z=4
	    WebView myWebView;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
			final GlobalClass globalvariabel = (GlobalClass)getApplicationContext();
			final String a=globalvariabel.Getvenuename();
			String url="https://www.google.com/maps/search/"+a;
	        super.onCreate( savedInstanceState );
	        setContentView( R.layout.activity_map);
	        //url=getIntent().getStringExtra( "url" );
	        myWebView = (WebView)findViewById(R.id.mapview);
	        myWebView.getSettings().setJavaScriptEnabled(true);
	        myWebView.setWebViewClient(new WebViewClient());
	        myWebView.loadUrl(url);
	    }
	}

	

