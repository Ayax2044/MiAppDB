package com.example.fitnesapp

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class IMT : AppCompatActivity() {

    private lateinit var editTextWeight: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imt)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        editTextWeight = findViewById(R.id.editTextWeight)
        editTextHeight = findViewById(R.id.editTextHeight)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weight = editTextWeight.text.toString().toFloat()
        val height = editTextHeight.text.toString().toFloat()

        val bmi = weight / (height * height)

        val resultText = when {
            bmi < 18.5 -> "Недостаточный вес"
            bmi < 24.9 -> "Нормальный вес"
            bmi < 29.9 -> "Избыточный вес"
            else -> "Ожирение"
        }

        textViewResult.text = "ИМТ: %.2f\n%s".format(bmi, resultText)
    }

    fun backk1(view: View) {
        val but: Button = findViewById(R.id.button6)
        when (but?.id) {
            R.id.button6 -> finish()
        }
    }
}