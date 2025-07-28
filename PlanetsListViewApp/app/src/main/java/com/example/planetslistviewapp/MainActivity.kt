package com.example.planetslistviewapp

import android.os.Bundle
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

        // Create one listview to enable scrollable list on the screen
        val listView : ListView = findViewById(R.id.listv)

        // data source
        val planet1 = Planet("Mercury","0 Moons",R.drawable.planet1)
        val planet2 = Planet("Saturn","10 Moons",R.drawable.planet2)
        val planet3 = Planet("Earth","20 Moons",R.drawable.planet1)
        val planet4 = Planet("Jupiter","10 Moons",R.drawable.planet2)
        val planet5 = Planet("Saturn","12 Moons",R.drawable.planet1)

        val planetListView = ArrayList<Planet>()
        planetListView.add(planet1)
        planetListView.add(planet2)
        planetListView.add(planet3)
        planetListView.add(planet4)
        planetListView.add(planet5)

        // Adapter
        var adapter = PlanetAdapter(this,planetListView)

        // set the adapter with the listview
        listView.adapter = adapter
    }
}