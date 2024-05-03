package com.example.fitnesapp

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class VidiTrenirovok : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vidi_trenirovok)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
    fun v1 (view: View){
        val bb1 : ImageView = findViewById(R.id.imageView3)
        val intent: Intent = Intent(this, Sila::class.java)
        startActivity(intent)
    }
    fun v2 (view: View){
        val bb1 : ImageView = findViewById(R.id.imageView4)
        val intent: Intent = Intent(this, Cardio::class.java)
        startActivity(intent)
    }
    fun v3 (view: View){
        val bb1 : ImageView = findViewById(R.id.imageView4)
        val intent: Intent = Intent(this, Stretching::class.java)
        startActivity(intent)
    }
    fun bback (view: View) {
        val bb1: Button = findViewById(R.id.button5)
        when (bb1?.id) {
            R.id.button5 -> finish()
        }
    }
}