package com.hellowolrd.pets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter (private val animals : List<Animal>): RecyclerView.Adapter<AnimalAdapter.AnimalHolder>(){

    class AnimalHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun onBind(animal: Animal){
            val image = view.findViewById<ImageView>(R.id.image)
            val title = view.findViewById<TextView>(R.id.title)
            val content = view.findViewById<TextView>(R.id.content)

            image.setImageResource(animal.image)
            title.text = animal.title
            content.text = animal.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val layoutInflator = LayoutInflater.from(parent.context)
        val view = layoutInflator.inflate(R.layout.card_animal, parent, false)
        return AnimalHolder(view)
    }

    override fun onBindViewHolder(animalHolder: AnimalHolder, position: Int) {
        val animal = animals[position]
        animalHolder.onBind(animal)
    }

    override fun getItemCount(): Int {
        return animals.size
    }


}