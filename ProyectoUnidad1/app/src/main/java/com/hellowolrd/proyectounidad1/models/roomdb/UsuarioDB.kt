package com.hellowolrd.proyectounidad1.models.roomdb
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hellowolrd.proyectounidad1.models.dao.UsuarioDAO
import com.hellowolrd.proyectounidad1.models.entities.Usuario
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(
        entities = [Usuario::class],
        version = 2,
        exportSchema = true
)
abstract class UsuarioDB : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO

    companion object {
        @JvmStatic
        @Volatile
        private var instance: UsuarioDB? = null

        @Synchronized
        fun getInstance(context: Context): UsuarioDB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                        context,
                        UsuarioDB::class.java,
                        "content.db"
                )
                        .fallbackToDestructiveMigration()
                        .build()
                CoroutineScope(Dispatchers.IO).launch {
                    instance?.initDB()
                }
            }
            return instance as UsuarioDB
        }
    }

    suspend fun initDB() {
    }
}