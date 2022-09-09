package com.infnet.relacionamento_entre_entidades

import androidx.room.*

@Dao
interface FornecedorDAO {

    @Query("SELECT * FROM Fornecedor WHERE id = :id")
    fun obter(id: Int) : Fornecedor

    @Insert
    fun inserir(fornecedor:Fornecedor)

    @Update
    fun atualizar(fornecedor: Fornecedor)

    @Delete
    fun excluir(fornecedor: Fornecedor)

    @Query("SELECT * FROM fornecedor")
    fun listar(): List<Fornecedor>

}