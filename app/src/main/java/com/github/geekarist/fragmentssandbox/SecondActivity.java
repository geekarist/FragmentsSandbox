package com.github.geekarist.fragmentssandbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView helloAgainText = (TextView) findViewById(R.id.text_hello_again);
        helloAgainText.setText(getString(R.string.hello_again, getIntent().getExtras().getString("name")));
    }
}
