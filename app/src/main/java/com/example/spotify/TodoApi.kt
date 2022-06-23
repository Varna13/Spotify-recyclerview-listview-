//1
package com.example.spotify

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoApi {

    @GET("{ventorid}/config.json")
    fun getTodos(@Path("ventorid") ventorid : String): Call<Config>

    @GET("{contentUrl}")
    fun getContent(@Path("contentUrl") contentUrl : String) : Call<List<Artist>>
}