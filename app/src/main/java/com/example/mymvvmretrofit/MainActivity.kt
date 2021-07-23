package com.example.mymvvmretrofit

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.mymvvmretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activityViewModal: ActivityViewModal

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repositary = Repositary()
        val activityViewModelFactery = ActivityViewModelFactery(repositary)
        activityViewModal = ViewModelProvider(this, activityViewModelFactery).get(ActivityViewModal::class.java)

        activityViewModal.getdata()

        val datacurrent = intent.getStringExtra("date")
        val date = datacurrent.toString() + ".json"
        activityViewModal.date(date)

        activityViewModal.respone.observe(this, { responce ->
            binding.textView.text = responce?.body()?.disclaimer
            responce?.body()?.toString()?.let { Log.d("CALL", it) }

        })

    }
}



