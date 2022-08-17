package com.infnet.sqlitecomroom

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nome:String,
    val email:String,
    val telefone: String
    )