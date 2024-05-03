package com.example.fitnesapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fitnesapp.Vhod.DbHelper

class Avtorizachia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avtorizachia)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val userLogin : EditText = findViewById(R.id.user_login_auth)
        val userPass : EditText = findViewById(R.id.user_pass_auth)
        val button : Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, Registr::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userLogin.text.toString().trim()

            if (login == "" || pass == "") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
            else {

                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if(isAuth ){
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, ActivityTwo::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Пользователь $login не авторизован", Toast.LENGTH_SHORT).show()
            }
        }
    }
}