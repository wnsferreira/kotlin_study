package com.infnet.database_intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        --------------------------------------------------

        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "appDatabase.db"
        ).allowMainThreadQueries().build()

//        ---------------------------------------------------

        db.livroDao().insert(
            Livro(
                null,
                "Meu livro",
                "Aguiar",
                "Didático"
            )
        )
//        ----------------------------------------------------

//        Verificar se inseriu
        val qtd = db.livroDao().all().size.toString()
        Log.i("DR3", "Eu inseri $qtd livros no banco de dados")

//        -----------------------------------------------------
    }
}