package com.example.locations

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationRequest

class MainActivity : AppCompatActivity() {

    var fusedLocationClient: FusedLocationProviderClient? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // last known location
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)



        // we need permissions for both last known location as well as for tracking position updates
        if (checkPermission(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION)){
            fusedLocationClient?.lastLocation?.
            addOnSuccessListener(this,
                {location : Location? ->
                    // Got last known location. In some rare
                    // situations this can be null.
                    if(location == null) {
                        // TODO, handle it
                    } else location.apply {
                        // Handle location object
                        Log.e("LOG", location.toString())
                    }
                })
        }

    }


    val PERMISSION_ID = 42
    private fun checkPermission(vararg perm:String) :
            Boolean {
        val havePermissions = perm.toList().all {
            ContextCompat.checkSelfPermission(this,it) ==
                    PackageManager.PERMISSION_GRANTED
        }
        if (!havePermissions) {
            if(perm.toList().any {
                    ActivityCompat.
                    shouldShowRequestPermissionRationale(this, it)}
            ) {
                val dialog = AlertDialog.Builder(this)
                    .setTitle("Permission")
                    .setMessage("Permission needed!")
                    .setPositiveButton("OK",{
                            id, v ->
                        ActivityCompat.requestPermissions(
                            this, perm, PERMISSION_ID)
                    })
                    .setNegativeButton("No",{
                            id, v ->
                    })
                    .create()
                dialog.show()
            } else {
                ActivityCompat.requestPermissions(this, perm,
                    PERMISSION_ID)
            }
            return false
        }
        return true
    }

}