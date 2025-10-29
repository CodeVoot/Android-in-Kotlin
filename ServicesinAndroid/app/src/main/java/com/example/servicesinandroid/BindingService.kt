package com.example.servicesinandroid

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Binder
import java.text.SimpleDateFormat
import java.util.*

class BindingService : Service() {


    // In Android, binding is a way for other components (like Activities)
    // to interact directly with a service — for example, to call its methods, get its status, or receive callbacks.







    
//    private val binder = LocalBinder()

    // Binder class that clients will use to access the service
//    inner class LocalBinder : Binder() {
//        fun getService(): MyBoundService = this@MyBoundService
//    }

    override fun onBind(intent: Intent): IBinder {
        return TODO("mg jklsrengrjkaghjklren")
    }
//
//
//    // Example method that clients can call
//    fun getCurrentTime(): String {
//        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
//        return dateFormat.format(Date())
//    }
}