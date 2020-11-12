package com.hellowolrd.proyectounidad1.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.hellowolrd.proyectounidad1.models.entities.Usuario
import com.hellowolrd.proyectounidad1.models.roomdb.UsuarioDB

class UsuarioRepository(context: Context) {

    private val usuarioDB = UsuarioDB.getInstance(context)
    private val usuarioDAO = usuarioDB.usuarioDAO()

    suspend fun insertUsuario(usuario: Usuario) {
        usuarioDAO.insertUsuario(usuario)
    }

    suspend fun getAllUsuarios(): List<Usuario> {
        return usuarioDAO.getAllContentSync()
    }

    fun getAllUsuariosLiveData(): LiveData<List<Usuario>> {
        return usuarioDAO.getAllContent()
    }
}