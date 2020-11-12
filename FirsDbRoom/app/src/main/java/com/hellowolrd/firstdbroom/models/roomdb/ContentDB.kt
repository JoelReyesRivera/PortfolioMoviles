package com.hellowolrd.firstdbroom.models.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hellowolrd.firstdbroom.entities.Content
import com.hellowolrd.firstdbroom.entities.dao.ContentDao

@Database(
    entities = [Content::class],
    version = 1,
    exportSchema = true
)
abstract  class ContentDB : RoomDatabase (){

  abstract fun contentDao(): ContentDao
    companion object{
        @Synchronized
            fun getInstance(context: Context): ContentDB{
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context,
                        ContentDB::class.java,
                        "content.db"
                    ).addCallback(object: RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    })
                        .allowMainThreadQueries()
                        .build()
                    instance?.
                }
                return instance as ContentDB
        }
    }

    fun initBD(){
        val contentDao = contentDao()
        if (contentDao.getAllContent().isEmpty()){
            contentDao.insertContent(
                Content(
                    nombre = "Joel",
                    lastname = "Reyes",
                    edad = 20
                )

                contentDao.insertContent(
                        Content(
                            nombre = "Bryan",
                            lastname = "Reyes",
                            edad = 17
                        )
                        )
            )
        }
    }
}

@Volatile
private var instance : ContentDB? = null