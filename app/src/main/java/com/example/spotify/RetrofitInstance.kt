//3
package com.example.spotify

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

   val api : TodoApi by lazy{
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/iamjijojohnny/experiments/main/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }

//    val api1 : TodoApi by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://github.com/iamjijojohnny/experiments/blob/main/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(TodoApi::class.java)
//    }
}