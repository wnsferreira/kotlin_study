package com.infnet.relacionamento_entre_entidades

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Fornecedor::class, Contato::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun obterFornecedorDAO(): FornecedorDAO

    abstract fun obterContatoDAO(): ContatoDAO
}