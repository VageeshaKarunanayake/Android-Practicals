package com.vageesha.lab06;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vageesha.database.DBHelper;
import com.vageesha.database.UserMaster;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbh;
    private EditText e1,e2;
    private String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DBHelper(this);
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
    }

    public void selectAll(View view){

        Cursor cursor = dbh.ReadAll();
    }

    public void delete(View view){
        s1 = e1.getText().toString();
        dbh.deleteInfo(s1);
    }

    public void update(View view){
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();

        dbh.updateInfo(s1,s2);
    }

    public void add(View view){
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();

        dbh.addInfo(s1,s2);
    }

    public void signIn(View view){
        s1 = e1.getText().toString();
        s2 = e2.getText().toString();
        String dbpwd = "crack";
        Cursor cursor = dbh.readPassword(s1);

        if(cursor.moveToNext()){
            dbpwd = cursor.getString(cursor.getColumnIndex(UserMaster.Users.COLUMN_NAME_PASSWORD));
        }

        if (dbpwd.equals(s2))
            Toast.makeText(this,"Signin successful",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Signin unsuccessful",Toast.LENGTH_LONG).show();
    }

}
