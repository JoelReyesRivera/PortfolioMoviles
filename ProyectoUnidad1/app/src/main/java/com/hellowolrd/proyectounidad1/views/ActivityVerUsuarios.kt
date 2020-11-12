package com.hellowolrd.proyectounidad1.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellowolrd.proyectounidad1.R
import com.hellowolrd.proyectounidad1.adapters.UsuarioAdapter
import com.hellowolrd.proyectounidad1.viewmodels.MainActivityViewModel

class ActivityVerUsuarios : AppCompatActivity(){

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.ver_usuarios)

            val recyclerView = findViewById<RecyclerView>(R.id.recycler_users)
            recyclerView.layoutManager = LinearLayoutManager(this)

            val viewModel : MainActivityViewModel by viewModels()
            viewModel.getAllUsuarios().observe(this, { usuarios ->
                val usuarioAdapter = UsuarioAdapter(usuarios)
                recyclerView.adapter = usuarioAdapter
                usuarioAdapter.notifyDataSetChanged()
            })
        }
}