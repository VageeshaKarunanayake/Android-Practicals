package com.vageesha.lab02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        Intent intent = getIntent();
        String value = intent.getStringExtra(FirstMainActivity.txt);

        TextView view = findViewById(R.id.textView);
        view.setText(value);
    }
}
