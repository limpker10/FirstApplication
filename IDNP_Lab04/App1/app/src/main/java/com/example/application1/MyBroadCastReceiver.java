package com.example.application1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Log.i("BroadcastReceiver", intent.getStringExtra("mensaje"));
        Toast.makeText(context,"Broadcast message into same app is received", Toast.LENGTH_LONG).show();


    }
}