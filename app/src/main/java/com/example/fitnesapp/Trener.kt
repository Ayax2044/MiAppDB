package com.example.fitnesapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.fitnesapp.DB.AppDatabase
import com.example.fitnesapp.DB.Student
import com.example.fitnesapp.databinding.ActivityTrenerBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Trener : AppCompatActivity() {

    private lateinit var binding : ActivityTrenerBinding
    private lateinit var appDb : AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrenerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fun back(view: View) {
            val but: ImageButton = findViewById(R.id.imageButton9)
            when (but?.id) {
                R.id.imageButton9 -> finish()
            }
        }

        appDb = AppDatabase.getDatabase(this)

        binding.save.setOnClickListener {
            writeData()
        }

        binding.read.setOnClickListener {
            readData()
        }

        binding.delete.setOnClickListener{
            GlobalScope.launch{
                appDb.studentDao().deleteAll()
            }
        }
        binding.button11.setOnClickListener {
            updateData()
        }
    }
    private fun updateData(){

        val firstName = binding.editTextText.text.toString()
        val lastName = binding.editTextText2.text.toString()
        val rollNo = binding.editTextText3.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()){

            GlobalScope.launch(Dispatchers.IO){
                appDb.studentDao().update(firstName,lastName,rollNo.toInt())
            }
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
            binding.editTextText3.text.clear()
            Toast.makeText(this@Trener,"Запись изменина",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@Trener,"Введите все данные",Toast.LENGTH_SHORT).show()
        }
    }

    private fun writeData(){

        val firstName = binding.editTextText.text.toString()
        val lastName = binding.editTextText2.text.toString()
        val rollNo = binding.editTextText3.text.toString()

        if (firstName.isNotEmpty() && lastName.isNotEmpty() && rollNo.isNotEmpty()){
            val student = Student(
                null,firstName,lastName,rollNo.toInt()
            )
            GlobalScope.launch(Dispatchers.IO){
                appDb.studentDao().insert(student)
            }
            binding.editTextText.text.clear()
            binding.editTextText2.text.clear()
            binding.editTextText3.text.clear()
            Toast.makeText(this@Trener,"Запись добавлена",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@Trener,"Введите все данные",Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun displayData(student: Student){
        withContext(Dispatchers.Main){
            binding.textView25.text = student.firstName.toString()
            binding.textView29.text= student.lastName.toString()
            binding.textView30.text= student.rollNo.toString()

        }
    }

    private  fun readData() {
        val rollNo = binding.editTextText4.text.toString()
        if (rollNo.isNotEmpty()) {
            lateinit var student: Student
            GlobalScope.launch {
                student = appDb.studentDao().findByRoll(rollNo.toInt())
                displayData(student)
            }
        }
    }
}

