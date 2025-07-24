package com.example.customadapter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //  to enable scrollable feature of list
        val myList : ListView = findViewById(R.id.list)

        // data modal to server the data
//        val operating = arrayOf("Windows","Linux","MAC OS")

        // Always use list over the array in case of custom layout
        val operating = listOf("Windows","Linux","MAC OS")

        // to serve the modal data onto the GUI

        // 1. It will not parse custom_layout without using custom adapter because
        // simple_list view contains only Textview not even any constraint and any other layout as well

//        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,operating)


        // 2. so that's why we need custom adapter

        val adapter = MyAdapter(this,operating)

        // connecting list with the adapter
        myList.adapter = adapter
    }
}