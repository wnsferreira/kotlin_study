package com.infnet.sqlitecomroom

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Contato::class), version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun obterContatoDAO(): ContatoDAO
}

//Uma classe abstrata não pode ser instanciada
//No entanto, você pode herdar subclasses delas.