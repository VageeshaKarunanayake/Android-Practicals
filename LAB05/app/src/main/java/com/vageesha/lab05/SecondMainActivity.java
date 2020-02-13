package com.vageesha.lab05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondMainActivity extends AppCompatActivity {
    private String num1 ="";
    private String num2 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        Intent intent = getIntent();
        num1 = intent.getStringExtra(MainActivity.nuz1);
        num2 = intent.getStringExtra(MainActivity.nuz2);

        EditText n1 = findViewById(R.id.editText3);
        EditText n2 = findViewById(R.id.editText4);
        n1.setText(num1);
        n2.setText(num2);
    }

    public void mul(View view){
        TextView tz = findViewById(R.id.textView);
        tz.setText(num1+" * "+num2+" = "+(Integer.toString(Integer.parseInt(num1)*Integer.parseInt(num2))));
    }

    public void div(View view){
        TextView tz = findViewById(R.id.textView);
        tz.setText(num1+" / "+num2+" = "+(Integer.toString(Integer.parseInt(num1)/Integer.parseInt(num2))));
    }

    public void sub(View view){
        TextView tz = findViewById(R.id.textView);
        tz.setText(num1+" - "+num2+" = "+(Integer.toString(Integer.parseInt(num1)-Integer.parseInt(num2))));
    }

    public void add(View view){
        TextView tz = findViewById(R.id.textView);
        tz.setText(num1+" + "+num2+" = "+(Integer.toString(Integer.parseInt(num1)+Integer.parseInt(num2))));
    }
}
