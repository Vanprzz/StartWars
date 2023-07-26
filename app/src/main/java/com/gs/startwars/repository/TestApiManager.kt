package com.gs.startwars.repository

import com.gs.startwars.model.Person
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object TestApiManager {

    fun getPersonSW(callback: (list: List<Person?>?) -> Unit){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://akabab.github.io/")
            .build()
        val service: ServicesSW = retrofit.create(ServicesSW::class.java)

        val call = service.persons

        call.enqueue(object : Callback<ArrayList<Person>> {
            override fun onFailure(call: Call<ArrayList<Person>>, t: Throwable) {
                callback(null)
            }

            override fun onResponse(
                call: Call<ArrayList<Person>>,
                response: Response<ArrayList<Person>>
            ) {
                callback(response.body())
            }
        })
    }



}

