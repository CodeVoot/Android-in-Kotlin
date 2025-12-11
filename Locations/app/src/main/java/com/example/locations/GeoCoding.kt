package com.example.locations

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

//  First we define kind of a contract between the service and the
//  service clients of a class holding some constants
class GeocoderConstants {
    companion object Constants {
        val SUCCESS_RESULT = 0
        val FAILURE_RESULT = 1
        val PACKAGE_NAME = "<put your package name here>"
        val RECEIVER = "$PACKAGE_NAME.RECEIVER"
        val RESULT_DATA_KEY =
            "$PACKAGE_NAME.RESULT_DATA_KEY"
        val LOCATION_DATA_EXTRA =
            "$PACKAGE_NAME.LOCATION_DATA_EXTRA"
    }
}


class GeoCoding : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_geo_coding)


        
    }
}