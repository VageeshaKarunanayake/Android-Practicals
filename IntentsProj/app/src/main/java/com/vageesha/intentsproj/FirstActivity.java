package com.vageesha.intentsproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    public static final String num11 = "num1";
    public static final String num22 = "num2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void onclickOK(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        EditText number1 = (EditText) findViewById(R.id.editText);
        EditText number2 = (EditText) findViewById(R.id.editText2);
        String num1 = number1.getText().toString();
        String num2 = number2.getText().toString();
        intent.putExtra(num11,num1);
        intent.putExtra(num22,num2);
        startActivity(intent);
    }
}
