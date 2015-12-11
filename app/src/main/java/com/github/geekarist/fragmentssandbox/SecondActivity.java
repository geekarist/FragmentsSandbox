package com.github.geekarist.fragmentssandbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        mName = getIntent().getExtras().getString("name");
        helloAgainText.setText(getString(R.string.hello_again, mName));

        View nextButton = findViewById(R.id.button_next2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class).putExtra("name", mName);
                startActivity(intent);
                finish();
            }
        });

        if (savedInstanceState == null) {
            Fragment editNameFragment = EditYourNameFragment.newInstance(mName);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_edit_your_name_container, editNameFragment)
                    .commit();
        }
    }

    @Override
    public void consumeName(String name) {
        mName = name;
    }
}
