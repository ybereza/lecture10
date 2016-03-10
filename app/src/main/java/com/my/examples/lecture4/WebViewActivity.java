/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebViewActivity extends AppCompatActivity {
	private WebView mWebView;
	private ProgressBar mProgressBar;

	private class MyWebViewClient extends WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			mProgressBar.setVisibility(View.GONE);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_view);
		mProgressBar = (ProgressBar)findViewById(R.id.progress_bar);

		mWebView = (WebView)findViewById(R.id.webview);
		mWebView.setWebViewClient(new MyWebViewClient());
		WebSettings settings = mWebView.getSettings();
		settings.setSupportZoom(true);
		settings.setBuiltInZoomControls(true);
		settings.setJavaScriptEnabled(true);
		settings.setLoadWithOverviewMode(true);
		settings.setDisplayZoomControls(false);
		settings.setLoadWithOverviewMode(true);

		mWebView.loadUrl("https://mail.ru");
	}

	@Override
	public void onBackPressed() {
		if (mWebView.canGoBack()) {
			mWebView.goBack();
		}
		else {
			super.onBackPressed();
		}
	}
}
