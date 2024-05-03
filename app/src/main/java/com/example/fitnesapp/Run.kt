package com.example.fitnesapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class Run : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run)
        val t: TextView = findViewById(R.id.textView)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        viewModel.elapsedTime.observe(this, Observer { elapsedTime ->
            t.text = formatTime(elapsedTime)
        })
    }
    fun ClickStart (view : View){
        viewModel.start()
    }
    fun ClickStop (view: View) {
        viewModel.stop()
    }
    fun back (view: View) {
        val b: Button = findViewById(R.id.button3)
        when (b.id) {
            R.id.button3 -> finish()
        }
    }
    private fun formatTime(milliseconds: Long): String {
        val seconds = milliseconds / 1000
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }
}

