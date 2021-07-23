package com.example.mymvvmretrofit

import android.os.Build
import androidx.annotation.RequiresApi


class Repositary {
    var client:PostApi=RetrofitInstance.getApi
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getData(date: String)=client.getData(date)
}