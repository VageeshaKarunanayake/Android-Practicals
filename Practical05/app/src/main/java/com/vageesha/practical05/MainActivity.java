package com.vageesha.practical05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbh;
    EditText oID,des,cusID,proID,qty,tPrice;
    String s1,s2,s3,s4,s5,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new DBHelper(this);
    }

    public void selectAll(){

    }

    public void Add(View view){
        oID = findViewById(R.id.editText);
        s1 = oID.getText().toString();

        des = findViewById(R.id.editText2);
        s2 = des.getText().toString();

        cusID = findViewById(R.id.editText3);
        s3 = cusID.getText().toString();

        proID = findViewById(R.id.editText5);
        s4 = proID.getText().toString();

        qty = findViewById(R.id.editText6);
        s5 = qty.getText().toString();

        tPrice = findViewById(R.id.editText7);
        s6 = tPrice.getText().toString();

        dbh.addInfo(s1,s2,s3,s4,s5,s6);

        Toast.makeText(this,
                "Order added Successfully", Toast.LENGTH_LONG).show();

    }

    public void delete(View view){
        dbh.deleteAllInfo();
        //Toast.makeText(this,
          //      "Order deleted Successfully", Toast.LENGTH_LONG).show();

        View toastView = getLayoutInflater().inflate(R.layout.my_toast, null);
        ImageView imge = toastView.findViewById(R.id.customToastImage);
        imge.setImageResource(R.drawable.download);
        // Initiate the Toast instance.
        Toast toast = new Toast(getApplicationContext());
        // Set custom view in toast.
        toast.setView(toastView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0,60);
        toast.show();

    }
}
