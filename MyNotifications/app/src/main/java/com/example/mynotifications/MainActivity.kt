package com.example.mynotifications

import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.RemoteInput
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Button click will trigger notification
        findViewById<android.view.View>(R.id.btnNotify).setOnClickListener {
            requestPermissionAndNotify()
        }

    }

    // Android 13+ requires user permission
    private fun requestPermissionAndNotify() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    100
                )
                return
            }
        }
        showNotification()
    }

    private fun showNotification() {

        // Ensures notification channel exists
        buildChannel(NOTIFICATION_CHANNEL_ID)

        // When user tapped on the screen, Android needs to know which activity should open after that
        val tapIntent = Intent(this, AlertDetails::class.java)

        // It creates a permission token that allows Android to open an Activity later when the user taps the notification.
        val tapPendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )


        /*   If we don't want to add inline reply feeature then add this one only and remove the other one

        val actionIntent = Intent(this, MyReceiver::class.java).apply {
            action = "com.xyz.MAIN"
            putExtra(EXTRA_NOTIFICATION_ID, NOTIFICATION_ID)
        }

        // broadcast intent goes to MyReceiver
        val actionPendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            actionIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        ) */

        //  when other user sends a reply, call broadcast receiver
        val replyIntent = Intent(this, MyReceiver::class.java).apply {
            action = ACTION_REPLY
            putExtra(EXTRA_NOTIFICATION_ID, NOTIFICATION_ID)
        }

        val replyPendingIntent = PendingIntent.getBroadcast(
            this,
            1,
            replyIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        )

        // 🔹 RemoteInput (Inline Reply)
        val remoteInput = RemoteInput.Builder(KEY_TEXT_REPLY)
            .setLabel("Type your reply")
            .build()

        val replyAction = NotificationCompat.Action.Builder(
            R.drawable.ic_action,
            "Reply",
            replyPendingIntent
        )
            .addRemoteInput(remoteInput)
            .setAllowGeneratedReplies(true)
            .build()


        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Hello Notification")
            .setContentText("Tap to open or reply directly")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(tapPendingIntent)
            .setAutoCancel(true)
            .addAction(replyAction) // ✅ Inline Reply added
            .build()

        /* Use when dont want to add inline reply feature

        // this is when we drag the notification from the top side
        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Hello Notification")
            .setContentText("Tap to open details or press Go.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(tapPendingIntent)
            .setAutoCancel(true)
            .addAction(
                R.drawable.ic_action,
                "Go",
                actionPendingIntent
            )
            .build()

          */


        NotificationManagerCompat.from(this)
            .notify(NOTIFICATION_ID, notification)
    }

}