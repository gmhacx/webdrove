package com.taquilla.webdrove;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.lang.ref.WeakReference;

/**
 * Creado por jcvallejo en 12/5/17.
 */

class WebDroveViewClient extends WebViewClient {
    private final WeakReference<WebDrobeView> view;
    private final WebDrobeUrlHandler webDrobeUrlHandler;

    WebDroveViewClient(WebDrobeView view, WebDrobeUrlHandler webDrobeUrlHandler) {
        this.view = new WeakReference<>(view);
        this.webDrobeUrlHandler = webDrobeUrlHandler;
    }

    public void setInitialUrl(String url) {
        this.updateViewWithUrl(url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        WebDrobeUrlHandler.UrlAction action = webDrobeUrlHandler.handleUrl(url);
        if (action.shouldOverrideUrlLoading) {
            view.getContext().startActivity(action.intent);
        }

        updateViewWithUrl(url);

        return action.shouldOverrideUrlLoading;
    }

    private void updateViewWithUrl(String url) {
        WebDrobeView v = this.view.get();
        if (v != null) {
            v.setSubtitle(url);
            v.setSecureIconVisible(url.startsWith("https"));
        }
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return this.shouldOverrideUrlLoading(view, request.getUrl().toString());
    }
}
