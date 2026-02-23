package com.example.contacsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// pass your data modal class as a parameter here
class ContactsAdapter (private val contacts:List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>(){

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.username)
        val number: TextView = view.findViewById(R.id.usernumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.name.text = contact.name
        holder.number.text = contact.number
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}