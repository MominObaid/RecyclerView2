package com.example.recyclerview2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubApiObj {
    val baseUrl = "https://api.github.com"
    fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}