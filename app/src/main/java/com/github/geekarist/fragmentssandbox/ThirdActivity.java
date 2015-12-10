package com.github.geekarist.fragmentssandbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView helloFinallyText = (TextView) findViewById(R.id.text_hello_finally);
        String name = getIntent().getStringExtra("name");
        helloFinallyText.setText(getString(R.string.hello_finally, name));
    }
}
