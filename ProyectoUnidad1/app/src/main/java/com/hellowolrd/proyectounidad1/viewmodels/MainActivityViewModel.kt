package com.hellowolrd.proyectounidad1.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.hellowolrd.proyectounidad1.models.entities.Usuario
import com.hellowolrd.proyectounidad1.repositories.UsuarioRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application)  {

    private val usuarioRepository = UsuarioRepository(application)
    private val TAG = MainActivityViewModel::class.java.name
    private val insertLiveData = MutableLiveData<Boolean>()

    fun insertUsuario(usuario: Usuario) = viewModelScope.launch {
        try {
            usuarioRepository.insertUsuario(usuario)
            insertLiveData.postValue(true)
        } catch (ex: Exception) {
            Log.e(TAG, ex.message, ex)
            insertLiveData.postValue(false)
        }
    }
    fun notfyInsertUsuario() : LiveData<Boolean> = insertLiveData

    fun getAllUsuarios() : LiveData<List<Usuario>> = liveData {
        emit(usuarioRepository.getAllUsuarios())
    }
}