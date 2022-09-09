package com.infnet.relacionamento_entre_entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var idFornecedor: Int?= null,
    val nome: String,
    val email: String,
    val fone: String
)
