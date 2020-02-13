package com.vageesha.intentsproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
        protected int n1;
        protected int n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String num1 = intent.getStringExtra(FirstActivity.num11);
        String num2 = intent.getStringExtra(FirstActivity.num22);

        EditText edit1 = findViewById(R.id.editText);
        edit1.setText(num1);

        EditText edit2 = findViewById(R.id.editText2);
        edit2.setText(num2);

        n1 = Integer.parseInt(num1);
        n2 = Integer.parseInt(num2);
    }

    public void onclick1(View view){
        int x = n1 * n2;
        TextView t1 = findViewById(R.id.textView3);
        t1.setText(Integer.toString(x));
    }

    public void onclick2(View view){
        int x = n1 - n2;
        TextView t1 = findViewById(R.id.textView3);
        t1.setText(Integer.toString(x));
    }

    public void onclick3(View view){
        int x = n1 + n2;
        TextView t1 = findViewById(R.id.textView3);
        t1.setText(Integer.toString(x));
    }

    public void onclick4(View view){
        int x = n1 / n2;
        TextView t1 = findViewById(R.id.textView3);
        t1.setText(Integer.toString(x));
    }
}
