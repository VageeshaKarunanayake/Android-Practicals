package com.vageesha.lab08;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView t1,t2,t3,t4,t5;
    private SensorManager sensorManager;
    private Sensor sensor;
    private boolean color = false;
    private View view;
    private long lastUpdated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);

        t1 = findViewById(R.id.X);
        t2 = findViewById(R.id.Y);
        t3 = findViewById(R.id.Z);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        t1.setText("X : "+event.values[0]);
        t2.setText("Y : "+event.values[1]);
        t3.setText("Z : "+event.values[2]);

        if(event.values[0] > 2){
            t5.setBackgroundResource(R.color.pink);
            t4.setTextColor(Color.parseColor("#FF4081"));
        }else if(event.values[0] < -2){
            t5.setBackgroundResource(R.color.red);
            t4.setTextColor(Color.parseColor("#ffcc0000"));
        }else{
            t5.setBackgroundResource(R.color.yellow);
            t4.setTextColor(Color.parseColor("#ffff00"));
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
