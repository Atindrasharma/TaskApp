package com.example.mymvvmretrofit.dataclass

data class Getdata(
    val base: String,
    val disclaimer: String,
    val license: String,
    val rates: Rates,
    val timestamp: Int
)