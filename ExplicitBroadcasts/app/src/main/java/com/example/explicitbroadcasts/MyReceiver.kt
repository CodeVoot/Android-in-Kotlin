package com.example.explicitbroadcasts


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val msg = intent?.getStringExtra("myExtra")
        Toast.makeText(context, "Broadcast received: $msg", Toast.LENGTH_LONG).show()
        Log.e("LOG", "Received broadcast with message: $msg")

        // Simulate some work
        Thread.sleep(3000)
        Log.e("LOG", "Broadcast done")
    }
}