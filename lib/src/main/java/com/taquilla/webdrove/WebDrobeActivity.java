package com.taquilla.webdrove;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class WebDrobeActivity extends AppCompatActivity implements WebDrobeView {
    public static final String EXTRA_URL = "url";

    private WebView webView;
    private ProgressBar progressView;
    private WebDrobeTitleView title;
    private WebDroveViewClient webViewClient;

    @Override
    @SuppressLint("SetJavaScriptEnabled")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wd_activity_web_drove);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.title = (WebDrobeTitleView) this.findViewById(R.id.title);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.wd_close_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        this.progressView = (ProgressBar) this.findViewById(R.id.progress);

        this.webView = (WebView) this.findViewById(R.id.web);
        this.webView.setWebChromeClient(new WebDrobeChromeClient(this));
        this.webViewClient = new WebDroveViewClient(this, new WebDrobeDummyUrlHandler());
        this.webView.setWebViewClient(webViewClient);

        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        String url = this.getIntent().getStringExtra(EXTRA_URL);
        this.webViewClient.shouldOverrideUrlLoading(webView, url);
        webView.loadUrl(url);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wd_webdrove, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setLoadingProgress(int progress) {
        progressView.setProgress(progress < 100 ? progress : 0);
    }

    @Override
    public void setTitle(String title) {
        this.title.setTitle(title);
    }

    @Override
    public void setSubtitle(String subtitle) {
        this.title.setSubtitle(subtitle);
    }

    @Override
    public void setSecureIconVisible(boolean visible) {
        this.title.setSecureIconVisible(visible);
    }
}
