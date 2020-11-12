package com.hellowolrd.pets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val animalAdapter = AnimalAdapter(createAnimals())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = animalAdapter
        animalAdapter.notifyDataSetChanged()
    }

    fun createAnimals (): List<Animal>{
        val animals = mutableListOf<Animal>()

        animals.add(
            Animal (
                R.drawable.ic_buho,
                "Buho",
                "El buho es el animal que representa la sabiduria",
            )
        )

        animals.add(
            Animal (
                R.drawable.ic_lobo,
                "Lobo",
                "El lobo se encuentra en los bosques y tundras",
            )
        )

        animals.add(
            Animal (
                R.drawable.ic_murcielago,
                "Murcielago",
                "El murcielago es el animal favorito de batman",
            )
        )
        return animals
    }
}