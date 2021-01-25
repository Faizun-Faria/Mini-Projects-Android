package com.example.broadcaststatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class BroadcastRec extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConn = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if(noConn) Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            else Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
        }
    }
}
