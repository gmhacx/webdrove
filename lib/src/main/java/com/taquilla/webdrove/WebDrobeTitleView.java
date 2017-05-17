package com.taquilla.webdrove;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Creado por jcvallejo en 12/5/17.
 */

public class WebDrobeTitleView extends LinearLayout {
    private TextView title;
    private TextView subtitle;

    public WebDrobeTitleView(Context context) {
        this(context, null, 0);
    }

    public WebDrobeTitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WebDrobeTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WebDrobeTitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.init(context);
    }

    private void init(Context context) {
        this.setOrientation(VERTICAL);
        this.setGravity(Gravity.CENTER);
        View.inflate(context, R.layout.wd_view_toolbar_title, this);
        this.title = (TextView) findViewById(R.id.wd_tb_title);
        this.subtitle = (TextView) findViewById(R.id.wd_tb_subtitle);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setSubtitle (String subtitle) {
        this.subtitle.setText(subtitle);
    }

    public void setSecureIconVisible(boolean visible) {
        Drawable drawable = null;
        if (visible) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.wd_lock_white_12dp);
        }
        this.subtitle.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }
}
