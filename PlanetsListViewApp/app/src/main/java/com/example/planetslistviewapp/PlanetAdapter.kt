package com.example.planetslistviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class PlanetAdapter (val context: Context,val planets:List<Planet>) : BaseAdapter(){
    override fun getCount(): Int {
        // return the size of list
        return planets.size
    }

    override fun getItem(position: Int): Any {
        // return the exact position held by the item
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
        // return a unique identifier for the item at the specified position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // return a view to the specific id position
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view :View

         if(convertView==null){
             view = inflator.inflate(R.layout.custom_layout,parent,false)
         }else{
             view = convertView
         }

        // bind data to the view
        val item =  getItem(position) as Planet

        // Initialise the views
        val titleView = view.findViewById<ImageView>(R.id.imageView)
        val moonCountTextView = view.findViewById<TextView>(R.id.textcount)
        val moon_image = view.findViewById<TextView>(R.id.planet_name)

        titleView.setImageResource(item.imagePlanet)
        moonCountTextView.text = item.moonCount
        moon_image.text = item.title

        // Handling CLick events
        view.setOnClickListener{
            Toast.makeText(context,"You Clicked: ${planets[position].title} ",
                Toast.LENGTH_LONG).show()
        }

        return view
    }


}