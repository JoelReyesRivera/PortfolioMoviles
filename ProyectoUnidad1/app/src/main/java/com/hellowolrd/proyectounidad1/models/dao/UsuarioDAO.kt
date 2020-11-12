package com.hellowolrd.proyectounidad1.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hellowolrd.proyectounidad1.models.entities.Usuario

@Dao
abstract class UsuarioDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertUsuario(usuario: Usuario): Long

    @Query("SELECT * FROM Usuario")
    abstract fun getAllContent() : LiveData<List<Usuario>>

    @Query("SELECT * FROM Usuario")
    abstract suspend fun getAllContentSync() : List<Usuario>
}


