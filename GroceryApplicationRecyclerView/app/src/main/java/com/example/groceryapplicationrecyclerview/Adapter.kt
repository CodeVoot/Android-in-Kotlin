package com.example.groceryapplicationrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter(val itemList:ArrayList<Modal>) : RecyclerView.Adapter<Adapter.MyViewHolder>(){

    // holding references to the view for a single item in RecyclerView
    // itemView: represents the view for a single view in RV
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var itemImage:ImageView
        var itemTitle:TextView
        var itemDesc:TextView

        init{
            itemImage = itemView.findViewById(R.id.imageview)
            itemTitle = itemView.findViewById(R.id.title_text)
            itemDesc = itemView.findViewById(R.id.desc_text)

            itemView.setOnClickListener(){
                Toast.makeText(itemView.context,"You choose:  ${itemList[adapterPosition].title}",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // called when RV needs new ViewHolder Instance
        // inflating the layout for a single item and returning a new VH

        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout,parent,false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        // return the total number of items in the data set
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // bind data to viewHolder at specific position
        holder.itemTitle.setText(itemList[position].title)
        holder.itemDesc.setText(itemList[position].desc)
        holder.itemImage.setImageResource((itemList[position].image))
    }
}