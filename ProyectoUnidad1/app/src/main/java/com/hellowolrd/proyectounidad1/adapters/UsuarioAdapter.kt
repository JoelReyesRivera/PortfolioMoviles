package com.hellowolrd.proyectounidad1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hellowolrd.proyectounidad1.R
import com.hellowolrd.proyectounidad1.models.entities.Usuario

class UsuarioAdapter(private val usuarios: List<Usuario>) : RecyclerView.Adapter<UsuarioAdapter.UsuarioAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.usuario, parent, false)

        return UsuarioAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioAdapterViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.onBind(usuario)
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

    inner class UsuarioAdapterViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(usuario: Usuario) {
            val textViewName = view.findViewById<TextView>(R.id.textview_name)
            val textViewEmail = view.findViewById<TextView>(R.id.textview_email)
            val txtViewPassword = view.findViewById<TextView>(R.id.textview_password)
            val txtViewGustos = view.findViewById<TextView>(R.id.textview_gustos)
            val txtViewSexo = view.findViewById<TextView>(R.id.txtSexo)

            txtViewSexo.text = usuario.sexo
            textViewName.text = usuario.nombre
            textViewEmail.text = usuario.email
            txtViewPassword.text = usuario.password
            txtViewGustos.text = usuario.gustos
        }
    }
}