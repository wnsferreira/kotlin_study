package com.infnet.relacionamento_entre_entidades

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContatoDAO {

    @Query("SELECT * FROM Contato WHERE id = :id")
    fun obter(id: Int) : Contato

    @Insert
    fun inserir(contato: Contato)

    @Delete
    fun excluir(contato: Contato)

    @Query("SELECT * FROM contato")
    fun listar(): List<Contato>
}