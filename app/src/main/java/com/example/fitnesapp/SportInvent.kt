package com.example.fitnesapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.asLiveData
import com.example.fitnesapp.database.MainDatBas
import com.example.fitnesapp.database.predmet
import com.example.fitnesapp.databinding.ActivityEdaBinding
import com.example.fitnesapp.databinding.ActivitySportInventBinding
import com.example.fitnesapp.datbas.Item
import com.example.fitnesapp.datbas.MainDB

class SportInvent : AppCompatActivity() {
    lateinit var binding: ActivitySportInventBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportInventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun bacck1(view: View) {
            val but: ImageButton = findViewById(R.id.nazad)
            when (but?.id) {
                R.id.nazad -> finish()
            }
        }

        val db = MainDatBas.getDaBa(this)
        db.getDaO().getAllpredmet().asLiveData().observe(this){list->
            binding.textlist.text=""
            list.forEach{
                val text = "${it.name} гр      ${it.price} руб\n"
                binding.textlist.append(text)
            }
        }
        binding.btn.setOnClickListener {
            val predmet = predmet(null,
                binding.edname.text.toString(),
                binding.edprace.text.toString()
            )
            Thread{
                db.getDaO().insertpredmet(predmet)
            }.start()
        }
    }
}