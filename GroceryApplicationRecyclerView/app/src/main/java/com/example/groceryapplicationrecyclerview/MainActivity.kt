package com.example.groceryapplicationrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // View for the front screen which is RecyclerView in our case
        val recyclerView:RecyclerView = findViewById(R.id.recylerview)

        // how layout will be shown vertical or horizontal
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // data source
        val groceryItems: ArrayList<Modal> = ArrayList()

        val v1 = Modal("Fruits","This is mango fruit",R.drawable.image1)
        val v2 = Modal("Fruits","This is mango fruit",R.drawable.image2)
        val v3 = Modal("Fruits","This is mango fruit",R.drawable.images3)
        val v4 = Modal("Fruits","This is mango fruit",R.drawable.image1)
        val v5 = Modal("Fruits","This is mango fruit",R.drawable.image1)
        val v6 = Modal("Fruits","This is mango fruit",R.drawable.image2)
        val v7 = Modal("Fruits","This is mango fruit",R.drawable.images3)

        // Adapter
        val adapter = Adapter(groceryItems)

        // setting adapter to the UI view
        recyclerView.adapter = adapter

    }
}