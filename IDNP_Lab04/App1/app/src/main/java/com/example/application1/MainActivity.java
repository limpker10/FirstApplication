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
        IntentFilter intentFilter = new IntentFilter("com.Sending.Message.Sameapp");
        IntentFilter intentFilter1 = new IntentFilter("com.MyBroadcastMessage");
        MyBroadCastReceiver objReceiver = new MyBroadCastReceiver();
        registerReceiver(objReceiver, intentFilter1 );
        registerReceiver(objReceiver, intentFilter );
    }

    public void broadCastSendBtnClick(View view) {
        Intent intent = new Intent();
        intent.setAction("com.Sending.Message.Sameapp");
        intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}