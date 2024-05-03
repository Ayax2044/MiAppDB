package com.example.fitnesapp

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.os.Handler
import android.text.TextPaint
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_FitnesApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        Handler().postDelayed({
            val intent: Intent = Intent(this, Avtorizachia::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
        val t: TextView = findViewById(R.id.textView)
        val animation = TranslateAnimation(0f, 0f, 110f, 0f) // смещение на 200 единиц влево
        animation.duration = 1000
        animation.repeatCount = Animation.INFINITE // бесконечное повторение анимации
        t.startAnimation(animation)

        val paint: TextPaint = t.paint
                val width = paint.measureText(t.text.toString())
        val textShader: Shader = LinearGradient(
                0f, 0f, width, t.textSize,
        intArrayOf(Color.BLUE, Color.GREEN),
        null, Shader.TileMode.CLAMP
        )
        t.paint.shader = textShader
        t.invalidate()
    }
}
