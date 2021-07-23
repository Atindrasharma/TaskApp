package com.example.mymvvmretrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_date_picker.*
import java.util.*
import android.widget.Toast
import androidx.lifecycle.MutableLiveData

class DatePickerActivity : AppCompatActivity() {
    private lateinit var msg: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        getcurrentdate()
        selectdate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            intent.putExtra("date", getcurrentdate())
            startActivity(intent)
        }

    }

    private fun getcurrentdate():String{

        val today = Calendar.getInstance()
        datePicker1.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month: Int = month + 1
            val msg = "$year-$month-$day"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
      return msg

    }

}