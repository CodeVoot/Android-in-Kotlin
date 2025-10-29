package com.example.explicitremotebraodcastphonenumber

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.dialButton)
        button.setOnClickListener {
            val intent = Intent(this, MyBroadcastReceiver::class.java)
            intent.putExtra("phone_number", "1234567890")
            sendBroadcast(intent) // Explicit broadcast
        }
    }
}