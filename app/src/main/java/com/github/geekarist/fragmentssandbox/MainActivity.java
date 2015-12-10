package com.github.geekarist.fragmentssandbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View nextButton = findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        View cleanUpButton = findViewById(R.id.button_cleanup);
        cleanUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanUpText();
            }
        });
    }

    private void cleanUpText() {
        EditText nameText = (EditText) findViewById(R.id.text_name);
        String text = nameText.getText().toString();
        nameText.setText(text.toUpperCase());
    }
}
