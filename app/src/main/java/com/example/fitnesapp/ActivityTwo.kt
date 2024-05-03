package com.example.fitnesapp

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }
    fun b1 (view: View){
        val bb1 :ImageButton = findViewById(R.id.imageButton)
        val intent: Intent = Intent(this, Programm::class.java)
        startActivity(intent)
    }
    fun b2(view: View){
        val bb2:ImageButton = findViewById(R.id.imageButton3)
        val intent: Intent = Intent(this, Run::class.java)
        startActivity(intent)
    }
    fun b3(view: View){
        val bb3:ImageButton = findViewById(R.id.imageButton4)
        val intent: Intent = Intent(this, Soveti::class.java)
        startActivity(intent)
    }
    fun b4(view: View){
        val bb4:ImageButton = findViewById(R.id.imageButton5)
        val intent: Intent = Intent(this, Shagi::class.java)
        startActivity(intent)
    }
    fun Theme(view: View) {
        val sw: Switch = findViewById(R.id.switch1)
        if (sw.isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
    fun b5(view: View){
        val bb5:ImageButton = findViewById(R.id.imageButton6)
        val intent: Intent = Intent(this, VidiTrenirovok::class.java)
        startActivity(intent)
    }
    fun b6(view: View){
        val bb5:ImageButton = findViewById(R.id.imageButton2)
        val intent: Intent = Intent(this, History::class.java)
        startActivity(intent)
    }
    fun b7(view: View){
        val bb3:ImageButton = findViewById(R.id.imageButton4)
        val intent: Intent = Intent(this, IMT::class.java)
        startActivity(intent)
    }

    fun b8(view: View){
        val bb3:ImageButton = findViewById(R.id.imageButton8)
        val intent: Intent = Intent(this, VseYslugi::class.java)
        startActivity(intent)
    }
}