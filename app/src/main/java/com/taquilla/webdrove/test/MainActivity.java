package com.taquilla.webdrove.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.taquilla.webdrove.WebDrobeActivity;

public class MainActivity extends AppCompatActivity {
    private EditText urlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.urlView = (EditText) findViewById(R.id.url);
        findViewById(R.id.browse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebDrobeActivity.class);
                intent.putExtra(WebDrobeActivity.EXTRA_URL, urlView.getText().toString());
                startActivity(intent);
            }
        });
    }
}
