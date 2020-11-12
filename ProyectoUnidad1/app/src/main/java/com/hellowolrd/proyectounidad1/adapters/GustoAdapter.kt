package com.hellowolrd.proyectounidad1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hellowolrd.proyectounidad1.models.entities.Gusto
import com.hellowolrd.proyectounidad1.R

class GustoAdapter (private val gustos: List<Gusto>) :  RecyclerView.Adapter<GustoAdapter.GustoHolder>(){

    class GustoHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun onBind(gusto: Gusto){
            val image = view.findViewById<ImageView>(R.id.image)
            val title = view.findViewById<TextView>(R.id.title)

            image.setImageResource(gusto.image)
            title.text = gusto.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GustoHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val view = layoutInflator.inflate(R.layout.card_gusto, parent, false)
        return GustoHolder(view)
    }

    override fun onBindViewHolder(gustoHolder: GustoHolder, position: Int) {
        val gusto = gustos[position]
        gustoHolder.onBind(gusto)
    }

    override fun getItemCount(): Int {
        return gustos.size
    }

}