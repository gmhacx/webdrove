package com.taquilla.webdrove;

/**
 * Creado por jcvallejo en 12/5/17.
 */

class WebDrobeDummyUrlHandler implements WebDrobeUrlHandler {
    private static final UrlAction FIXED_ACTION = new UrlAction(false, null);

    @Override
    public UrlAction handleUrl(String url) {
        return FIXED_ACTION;
    }
}
