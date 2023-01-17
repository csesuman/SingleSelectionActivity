package com.example.singleselectionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.singleselectionactivity.singleselection.SingleSelectionRV

class MainActivity : AppCompatActivity() {


    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.recycleViewButton)
        button.setOnClickListener {
            val intent = Intent(this, SingleSelectionRV::class.java)
            startActivity(intent)
        }
    }
}