package com.example.mynotifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.RemoteInput


// Triggered when action button is pressed
// Shows Toast message

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if (intent.action == ACTION_REPLY) {
            val replyText = RemoteInput.getResultsFromIntent(intent)
                ?.getCharSequence(KEY_TEXT_REPLY)
                ?.toString()

            Toast.makeText(
                context,
                "Reply received: $replyText",
                Toast.LENGTH_LONG
            ).show()
        }




                    // if dont need inline reply

        /*
        Toast.makeText(
            context,
            "Action button clicked!",
            Toast.LENGTH_SHORT
        ).show()
        */
    }
}