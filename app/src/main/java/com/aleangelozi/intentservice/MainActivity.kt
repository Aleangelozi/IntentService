package com.aleangelozi.intentservice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val serviceInfo = findViewById<TextView>(R.id.serviceInfo)

        val start = findViewById<Button>(R.id.btnStart)
        start.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                serviceInfo.text = "Service running"
            }
        }

        val stop = findViewById<Button>(R.id.btnStop)
        stop.setOnClickListener {
            MyIntentService.stopService()
            serviceInfo.text = "Service stopped"
        }




    }
}