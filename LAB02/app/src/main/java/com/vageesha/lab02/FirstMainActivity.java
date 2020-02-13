package com.vageesha.lab02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FirstMainActivity extends AppCompatActivity {
    public static final String txt = "passingvalue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_main);
    }

    public void send(View view){
        EditText edit = findViewById(R.id.editText);
        String text = edit.getText().toString();

        Intent intent = new Intent(this,SecondMainActivity.class);
        intent.putExtra(txt,text);
        startActivity(intent);
    }
}
