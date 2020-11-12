package com.hellowolrd.firstdbroom.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hellowolrd.firstdbroom.entities.Content

@Dao
abstract class ContentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertContent(content : Content)

    @Query("SELECT * FROM Content")
    abstract fun getAllContent()

}