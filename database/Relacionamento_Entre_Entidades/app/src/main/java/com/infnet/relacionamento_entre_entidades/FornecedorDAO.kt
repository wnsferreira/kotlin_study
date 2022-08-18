package com.infnet.relacionamento_entre_entidades

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FornecedorDAO {

    @Insert
    fun inserir(fornecedor:Fornecedor)

    @Delete
    fun excluir(fornecedor: Fornecedor)

    @Query("SELECT * FROM fornecedor")
    fun listar(): List<Fornecedor>

}