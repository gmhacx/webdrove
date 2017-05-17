package com.taquilla.webdrove;

import android.content.Intent;

/**
 * Creado por jcvallejo en 12/5/17.
 */

interface WebDrobeUrlHandler {
    UrlAction handleUrl(String url);

    final class UrlAction {
        final boolean shouldOverrideUrlLoading;
        final Intent intent;

        public UrlAction(boolean shouldOverrideUrlLoading, Intent intent) {
            this.shouldOverrideUrlLoading = shouldOverrideUrlLoading;
            this.intent = intent;
        }
    }
}
