package com.hellowolrd.firstdbroom.entities

import androidx.room.Entity

@Entity
data class Content (
    val id : Long,
    val nombre:String,
    val lastname:String,
    val edad:Int
    )