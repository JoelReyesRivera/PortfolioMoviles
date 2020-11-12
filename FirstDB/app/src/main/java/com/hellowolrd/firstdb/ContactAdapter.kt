package com.hellowolrd.firstdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (private val contacts : List<ContactData>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder (private val view : View) : RecyclerView.ViewHolder(view){
        fun onBind(contactData: ContactData){
            val nombre = view.findViewById<TextView>(R.id.txtNombre)
            val apellido = view.findViewById<TextView>(R.id.txtApellido)
            val edad = view.findViewById<TextView>(R.id.txtEdad)

            nombre.text = contactData.nombre
            apellido.text = contactData.apellido
            edad.text = contactData.edad.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.onBind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}