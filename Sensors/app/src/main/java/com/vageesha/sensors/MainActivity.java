package com.vageesha.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView xText, yText, zText,colorText;
    private SensorManager sensorManager;
    private Sensor mySensor;
    private boolean color = false;
    private View view;
    private long lastUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        xText = (TextView) findViewById(R.id.textView);
        yText = (TextView) findViewById(R.id.textView2);
        zText = (TextView) findViewById(R.id.textView3);
        colorText = (TextView) findViewById(R.id.textView4);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x =event.values[0];
        float y =event.values[1];

        xText.setText("X :"+event.values[0]);
        yText.setText("Y :"+event.values[1]);
        zText.setText("Z :"+event.values[2]);

        if(x <= -2 ){
            colorText.setBackgroundResource(R.color.colorPrimaryDark);
        }
        if((x > -2) && (x < 2)){
            colorText.setBackgroundResource(R.color.yellow);
        }
        if(x >= 2 ){
            colorText.setBackgroundResource(R.color.red);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
