package com.github.geekarist.fragmentssandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements EditYourNameFragment.Listener {

    private String mName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView helloAgainText = (TextView) findViewById(R.id.text_hello_again);
        String name = getIntent().getExtras().getString("name");
        helloAgainText.setText(getString(R.string.hello_again, name));

        View nextButton = findViewById(R.id.button_next2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class).putExtra("name", mName);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void consumeName(String name) {
        mName = name;
    }
}
