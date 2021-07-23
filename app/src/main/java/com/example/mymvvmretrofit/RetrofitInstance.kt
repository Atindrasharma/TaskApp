package com.example.mymvvmretrofit
import com.example.mymvvmretrofit.ConstantData.Constant.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    val interceptor=HttpLoggingInterceptor().apply {
        this.level=HttpLoggingInterceptor.Level.BODY
    }
    val  client=OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
            .connectTimeout(30,TimeUnit.SECONDS)
            .readTimeout(20,    TimeUnit.SECONDS)
            .writeTimeout(25,TimeUnit.SECONDS)
    }.build()

    val Retroinctance: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val getApi: PostApi by lazy {
        Retroinctance.create(PostApi::class.java)
    }

}