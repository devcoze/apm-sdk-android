package com.devcoze.apm.sdk.demo

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = Button(this).apply {
            text = "CRASH"
            setOnClickListener {
                throw RuntimeException("Demo crash")
            }
        }

        setContentView(button)
    }
}