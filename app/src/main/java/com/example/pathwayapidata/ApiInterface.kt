package com.example.pathwayapidata

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("pathways")
    fun getData(@Query("courseType") courseType: String = "json"): Call<List<PathwayData>>
}

