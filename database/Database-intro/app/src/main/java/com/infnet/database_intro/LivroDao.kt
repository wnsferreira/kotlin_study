package com.infnet.database_intro

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LivroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg livros: Livro)

    @Query("SELECT * FROM livro")
    fun all():Array<Livro>

}