package com.example.application1;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter intentFilterApp1 = new IntentFilter("com.Sending.Message.Sameapp");
        IntentFilter intentFilterApp2 = new IntentFilter("com.sendBroadcastMessage");
        MyBroadCastReceiver objReceiver = new MyBroadCastReceiver();
        registerReceiver(objReceiver, intentFilterApp1 );
        registerReceiver(objReceiver, intentFilterApp2 );
    }

    public void broadCastSendBtnClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.Sending.Message.Sameapp");
        intent.putExtra("mensaje","Broadcast message into same app is received");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}