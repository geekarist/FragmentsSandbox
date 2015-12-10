package com.github.geekarist.fragmentssandbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View nextButton = findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", nameText.getText().toString());
                startActivity(intent);
            }
        });

        nameText = (EditText) findViewById(R.id.text_name);

        View cleanUpButton = findViewById(R.id.button_cleanup);
        cleanUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanUpText();
            }
        });
    }

    private void cleanUpText() {
        nameText.setText(nameText.getText().toString().toUpperCase());
    }
}
