package com.infnet.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnExecutar = this.findViewById<Button>(R.id.btnExecutar)
        btnExecutar.setOnClickListener{
            progressBarTest()
        }

    }

    private fun progressBarTest(){

        val prgProgressBar = this.findViewById<ProgressBar>(R.id.progressBar)
        val lblProgressBar = this.findViewById<TextView>(R.id.lblProgressBar)
        Thread(Runnable {

            for (i in 0..100){

                this@MainActivity.runOnUiThread(Runnable{
                    prgProgressBar.progress = i
                    lblProgressBar.text = i.toString() + "%"
                })
                Thread.sleep(200)
            }
        }).start()
    }
}