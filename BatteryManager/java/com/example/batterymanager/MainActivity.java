package com.example.batterymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private BatteryDataReciever bReciever = new BatteryDataReciever();
    private IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
        registerReceiver(bReciever, intentFilter);

    }

    protected void onPause(){
        unregisterReceiver(bReciever);
        super.onPause();

    }
}
