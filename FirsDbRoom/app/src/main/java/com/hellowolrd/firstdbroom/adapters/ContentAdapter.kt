package com.hellowolrd.firstdbroom.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hellowolrd.firstdbroom.R
import com.hellowolrd.firstdbroom.entities.Content
import kotlinx.android.synthetic.main.activity_add_conctact.view.*
import kotlinx.android.synthetic.main.contact.view.*

class ContentAdapter(private val contents: List<Content>) : RecyclerView.Adapter<ContentAdapter.ContentAdapterViewHolder>(){

    class ContentAdapterViewHolder (private val view : View) : RecyclerView.ViewHolder(view){
        fun onBind(content : Content){
           val textViewName =  view.findViewById<TextView>(R.id.txtNombre)
            val textViewLastName =  view.findViewById<TextView>(R.id.txtApellido)
            val textViewAge =  view.findViewById<TextView>(R.id.txtEdad)

            textViewName.text = content.nombre
            textViewLastName.text = content.lastname
            textViewAge.text = content.edad.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact, parent,false)
        return ContentAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentAdapterViewHolder, position: Int) {
        val content = contents[position]
        holder.onBind(content)
    }

    override fun getItemCount(): Int {
        return contents.size
    }
}