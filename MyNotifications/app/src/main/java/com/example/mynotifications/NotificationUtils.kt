package com.example.mynotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

fun Context.buildChannel(channelId: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            channelId,
            "Alert Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Notification Demo Channel"
        }

        val manager =
            getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

        manager.createNotificationChannel(channel)
    }
}