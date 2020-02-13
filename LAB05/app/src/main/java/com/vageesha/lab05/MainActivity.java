package com.vageesha.lab05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String nuz1 = "NUM1";
    public static final String nuz2 = "NUM2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ok(View view){
        EditText nu1 = findViewById(R.id.editText);
        EditText nu2 = findViewById(R.id.editText2);

        String num1 = nu1.getText().toString();
        String num2 = nu2.getText().toString();

        Intent intent= new Intent(this,SecondMainActivity.class);
        intent.putExtra(nuz1,num1);
        intent.putExtra(nuz2,num2);
        startActivity(intent);
    }
}
