package com.example.pathwayapidata

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)

        CoroutineScope(Dispatchers.Main).launch {
            val response = retrofitInstance.getData()
            response.enqueue(object : Callback<List<PathwayData>> {
                override fun onResponse(call: Call<List<PathwayData>>, response: Response<List<PathwayData>>) {
                    if (response.isSuccessful) {
                        Log.d("Hii", response.body().toString())
                    }
                }

                override fun onFailure(call: Call<List<PathwayData>>, t: Throwable) {
                    Log.d("Hello", t.message.toString())
                }

            }
            )
        }
    }
}