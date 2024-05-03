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
import com.example.fitnesapp.Vhod.User

class Registr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registr)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val userLogin : EditText = findViewById(R.id.user_login)
        val userEmail : EditText = findViewById(R.id.user_email)
        val userPass : EditText = findViewById(R.id.user_pass)
        val button : Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, Avtorizachia::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userLogin.text.toString().trim()
            val pass = userLogin.text.toString().trim()

            if(login == "" || email == "" || pass == ""){
                Toast.makeText(this,"Не все поля заполнены", Toast.LENGTH_SHORT).show()
            }
            else{
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $login добавлен", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityTwo::class.java)
                startActivity(intent)

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
        }

    }
}