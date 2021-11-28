package com.aleangelozi.services

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSendData = findViewById<Button>(R.id.btnSendData)
        val tvServiceInfo = findViewById<TextView>(R.id.serviceInfo)
        val btnStartService = findViewById<Button>(R.id.btnStart)
        val btnStopService = findViewById<Button>(R.id.btnStop)

        btnStartService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                tvServiceInfo.text = "Service Running"
            }
        }

        btnStopService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                tvServiceInfo.text = "Service Stopped"
            }
        }

        tvSendData.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = findViewById<EditText>(R.id.editText).text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }
    }
}