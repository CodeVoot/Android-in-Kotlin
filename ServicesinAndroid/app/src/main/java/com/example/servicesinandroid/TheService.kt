package com.example.servicesinandroid

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat


class TheService : Service() {

    private val CHANNEL_ID = "ForegroundServiceChannel"
    private var isRunning = true
    private val TAG = "ForegroundService"

    // called when the service is created once
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    // This method is called when we start the service
    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification: android.app.Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("My Foreground Service")
            .setContentText("Service is running...")
            .setSmallIcon(android.R.drawable.ic_menu_info_details)
            .build()

        startForeground(1, notification)

        Thread {
            while (isRunning) {
                Log.d(TAG, "Foreground service is running...")
                Thread.sleep(3000)
            }
        }.start()


        // If the system kills the service, try to restart it with null intent.
        return START_STICKY
    }

    // Called when the service is stopped or killed.
    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
        Log.d(TAG, "Foreground service stopped.")
    }

    // Binding is used when a component (Activity or fragment) wants to interact with the service directly
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    // just remove this piece of code to integrate the background service
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }

}