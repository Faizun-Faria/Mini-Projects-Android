package com.example.batterymanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.widget.TextView;

import static android.os.BatteryManager.BATTERY_STATUS_CHARGING;
import static android.os.BatteryManager.BATTERY_STATUS_DISCHARGING;
import static android.os.BatteryManager.BATTERY_STATUS_FULL;
import static android.os.BatteryManager.BATTERY_STATUS_NOT_CHARGING;

public class BatteryDataReciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        TextView status = ((MainActivity)context).findViewById(R.id.chargingS);
        TextView percentage = ((MainActivity)context).findViewById(R.id.batteryP);
        String action = intent.getAction();
        if(action != null && action.equals(Intent.ACTION_BATTERY_CHANGED) ){
            int batteryStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            Resources res = context.getResources();
            String display = "";

            if (batteryStatus == BATTERY_STATUS_FULL){
                display = "Battery Full";
            }else if(batteryStatus == BATTERY_STATUS_DISCHARGING){
                display = "Battery is discharging";
            }else if(batteryStatus == BATTERY_STATUS_CHARGING){
                display = "Charging";
            }else if(batteryStatus == BATTERY_STATUS_NOT_CHARGING){
                display = "Not Charging";
            }
            status.setText(display);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);
            int ans = (100*level)/scale;
            percentage.setText(ans+"%");
        }
    }
}
