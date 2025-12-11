package com.example.alarmmanager

import android.app.AlarmManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val alr = getSystemService(AlarmManager::class.java)
        alr.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + 10000,"",AlarmManager.OnAlarmListener {
            Log.d("Alarm","Alarm Triggered!") }
            ,null)
    }
}