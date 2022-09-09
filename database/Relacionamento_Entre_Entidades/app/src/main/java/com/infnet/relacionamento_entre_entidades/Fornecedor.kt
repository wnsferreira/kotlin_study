package com.infnet.relacionamento_entre_entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Fornecedor (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val razaoSocial: String,
    val cnpj: String
)