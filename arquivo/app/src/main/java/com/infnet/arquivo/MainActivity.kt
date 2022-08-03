package com.infnet.arquivo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGravar =  this.findViewById<Button>(R.id.btnGravar)
        btnGravar.setOnClickListener {

            val txtTexto = this.findViewById<EditText>(R.id.txtTexto)
            val fos = this.openFileOutput("texto.txt", MODE_PRIVATE)
            val bytes = txtTexto.text.toString().toByteArray()
            fos.write(bytes)
            fos.close()
        }

        val btnLer = this.findViewById<Button>(R.id.btnLer)
        btnLer.setOnClickListener{

            val lblTexto = this.findViewById<TextView>(R.id.lblTexto)
            val fis : FileInputStream = this.openFileInput("texto.txt")
            val bytes = fis.readBytes()
            fis.close()
            lblTexto.setText(String(bytes))
        }

//        No inputStream não é obrigatório colocar o close(). Pq o Garbage Collection já faz isso.
    }
}