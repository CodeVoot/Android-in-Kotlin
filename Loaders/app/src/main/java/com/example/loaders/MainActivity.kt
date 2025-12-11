package com.example.loaders

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader

class MainActivity : AppCompatActivity(),LoaderManager.LoaderCallbacks<Mydata> {
    val LOADER_ID = 42
    val loaded:Mydata? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Mydata> {
        Log.e("LOG","onCreateLoader()")
        return makeLoader()
    }

    override fun onLoadFinished(loader: Loader<Mydata>, data: Mydata?) {
        Log.e("LOG","load finished" + data)
        loaded = data
    }

    override fun onLoaderReset(loader: Loader<Mydata>) {
        Log.e("LOG","loader reset")
        loaded = null
    }
}