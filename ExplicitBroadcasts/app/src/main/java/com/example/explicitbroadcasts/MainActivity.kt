package com.example.explicitbroadcasts

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var myReceiver: MyReceiver

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create receiver instance
        myReceiver = MyReceiver()
        // Register the receiver for our custom action
        val filter = IntentFilter("com.example.MY_ACTION")
        registerReceiver(myReceiver, filter)

        // --- Send the broadcast ---
        val intent = Intent("com.example.MY_ACTION")
        intent.putExtra("myExtra", "Hello Receiver!")
        Log.e("LOG", "Sending broadcast")
        sendBroadcast(intent)
        Log.e("LOG", "Broadcast sent")

    }

    override fun onDestroy() {
        super.onDestroy()
        // Unregister receiver to avoid memory leaks
        unregisterReceiver(myReceiver)
    }
}