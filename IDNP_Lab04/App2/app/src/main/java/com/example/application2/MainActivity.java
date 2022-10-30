package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onBroadcastSentBtn(View v) {
        EditText mensaje = findViewById(R.id.editMensaje);
        String txt = mensaje.getText().toString();
        Intent intent = new Intent();
        intent.setAction("com.MyBroadcastMessage");
        intent.putExtra("mensaje",txt);
        sendBroadcast(intent);
    }
}