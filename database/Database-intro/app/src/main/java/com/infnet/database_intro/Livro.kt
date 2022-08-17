package com.infnet.database_intro

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Livro (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val titulo: String,
    val autores: String,
    val categorias: String,
    val editora: String? = null,
    val ano: Int? = 0,
    val paginas: Int? = 0
)

// val editora: String? = null,
// String? - o "?" serve para permitir um valor nulo. senão dar erro de nullPointException.