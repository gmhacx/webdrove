package com.taquilla.webdrove;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.lang.ref.WeakReference;

/**
 * Creado por jcvallejo en 12/5/17.
 */

class WebDrobeChromeClient extends WebChromeClient {
    private final WeakReference<WebDrobeView> view;

    WebDrobeChromeClient(WebDrobeView view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void onProgressChanged(WebView webView, int newProgress) {
        WebDrobeView v = this.view.get();
        if (v != null) {
            v.setLoadingProgress(newProgress);
        }
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        WebDrobeView v = this.view.get();
        if (v != null) {
            v.setTitle(title);
        }
    }


}
