package com.infnet.database_intro

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(Livro::class),
    version = 1
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun livroDao() : LivroDao
}