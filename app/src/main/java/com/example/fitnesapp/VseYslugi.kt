package com.example.fitnesapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class VseYslugi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vse_yslugi)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }
    fun zal (view: View){
        val bb1 : ImageView = findViewById(R.id.zal)
        val intent: Intent = Intent(this, zall::class.java)
        startActivity(intent)
    }
    fun trener (view: View){
        val bb1 : ImageView = findViewById(R.id.zal)
        val intent: Intent = Intent(this, Trener::class.java)
        startActivity(intent)
    }

    fun eda (view: View){
        val bb1 : ImageView = findViewById(R.id.eda)
        val intent: Intent = Intent(this, Eda::class.java)
        startActivity(intent)
    }
    fun inventar (view: View){
        val bb1 : ImageView = findViewById(R.id.inventar)
        val intent: Intent = Intent(this, SportInvent::class.java)
        startActivity(intent)
    }
}