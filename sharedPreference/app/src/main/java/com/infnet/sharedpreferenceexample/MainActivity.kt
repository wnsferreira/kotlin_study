package com.infnet.sharedpreferenceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //----------------------------------------------------------------------------
        val btnSalvar = this.findViewById<Button>(R.id.btnSalvar)
        btnSalvar.setOnClickListener {

            val txtString = this.findViewById<EditText>(R.id.txtString)
            val txtInteiro = this.findViewById<EditText>(R.id.txtInteiro)
            val sharedPrefs = this.getSharedPreferences("teste.sp", MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString("string", txtString.text.toString())
            editor.putInt("inteiro", txtInteiro.text.toString().toInt())
            editor.commit()
            Toast.makeText(this, "Dados Salvos", Toast.LENGTH_LONG).show()
        }

        //----------------------------------------------------------------------------
        val btnLer = this.findViewById<Button>(R.id.btnLer)
        btnLer.setOnClickListener{

            val sharedPrefs = this.getSharedPreferences("teste.sp", MODE_PRIVATE)
            val string = sharedPrefs.getString("string", "")
            val inteiro = sharedPrefs.getInt("inteiro", 0)
            val lblLido = this.findViewById<TextView>(R.id.lblLido)
            lblLido.setText("Dado 1 = $string e Dado 2 = $inteiro")
        }

    }
}