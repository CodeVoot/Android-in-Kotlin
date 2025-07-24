package com.example.customadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val context:Context,private val items:List<String>)  : BaseAdapter() {
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        // return the data item associated with the specified position in the data set
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        // it ensures that each item has it's own unique ID
        // return unique identifier for the item at the specified position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // finally return a view that is going to display the data

        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view :View

        if(convertView==null){
            // inflate new view using layout inflater
            view = inflator.inflate(R.layout.my_custom_layout,parent,false)
        }else{

            // resuing the samew view again
            view = convertView
        }


        // bind data to view
        val item = getItem(position) as String
        val titleTextView  = view.findViewById<TextView>(R.id.textViewCustom)

        titleTextView.text = item.toString()
        return view

    }
}