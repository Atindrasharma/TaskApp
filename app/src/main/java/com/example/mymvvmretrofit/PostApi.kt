package com.example.mymvvmretrofit

import com.example.mymvvmretrofit.dataclass.Getdata
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate

const val APP_ID ="b8170f2960a546378a5ceb06a7bb6f59"
interface PostApi {
@GET("historical/{message}")

suspend fun getData(@Path(value = "message",encoded = true) date:String, @Query(value = "app_id") app_id:String= APP_ID):Response<Getdata>

}


