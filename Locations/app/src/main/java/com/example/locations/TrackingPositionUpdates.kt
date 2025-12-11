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
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsStates
import com.google.android.gms.tasks.RuntimeExecutionException

class TrackingPositionUpdates : AppCompatActivity() {

    var fusedLocationClient: FusedLocationProviderClient? = null

    // tracking position updates
    val reqSetting = LocationRequest.create().apply {
        fastestInterval = 10000
        interval = 10000
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        smallestDisplacement = 1.0f
    }


    val REQUEST_CHECK_STATE = 12300 // any suitable ID

    val builder = LocationSettingsRequest.Builder()
        .addLocationRequest(reqSetting)

    val client = LocationServices.getSettingsClient(this)

//    client.checkLocationSettings(builder.build())
//    .addOnCompleteListener { task ->
//        try {
//            val result = task.result
//            val state: LocationSettingsStates = result.locationSettingsStates
//
//            Log.e(
//                "LOG",
//                """
//                LocationSettings:
//                BLE present: ${state.isBlePresent}
//                BLE usable: ${state.isBleUsable}
//                GPS present: ${state.isGpsPresent}
//                GPS usable: ${state.isGpsUsable}
//                Location present: ${state.isLocationPresent}
//                Location usable: ${state.isLocationUsable}
//                Network Location present: ${state.isNetworkLocationPresent}
//                Network Location usable: ${state.isNetworkLocationUsable}
//                """.trimIndent()
//            )
//
//        } catch (e: Exception) {
//            // If location settings are not satisfied, try to resolve
//            val cause = e.cause
//            if (cause is ResolvableApiException) {
//                cause.startResolutionForResult(
//                    this@MainActivity,
//                    REQUEST_CHECK_STATE
//                )
//            }
//        }
//    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tracking_position_updates)



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