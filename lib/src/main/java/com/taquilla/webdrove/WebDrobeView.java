package com.taquilla.webdrove;

/**
 * Creado por jcvallejo en 12/5/17.
 */

interface WebDrobeView {
    void setLoadingProgress(int progress);

    void setTitle(String title);

    void setSubtitle(String subtitle);

    void setSecureIconVisible(boolean visible);
}
