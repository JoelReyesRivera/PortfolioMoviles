package com.hellowolrd.proyectounidad1.models.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario
    (
            @PrimaryKey(autoGenerate = true)
            val id: Long? = null,
            val nombre: String,
            val email: String,
            val password: String,
            val gustos: String,
            val sexo: String
    )
    {
        override fun equals(other: Any?): Boolean {
            if (other is Usuario) {
                return other.id == this.id //&& name == otherObj.name
            }
            return false
        }
    }
