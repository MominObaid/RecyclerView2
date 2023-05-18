package com.example.recyclerview2
import com.google.firebase.database.core.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


val BASE_URL = "https://githubtrendingapi.docs.apiary.io/#reference/0/repositories"
interface MyRetrofit {

    @GET("/list-trending-repositories")
    fun getRepos() : Call<List<Repo>>
}

object MyRetrofitObj{
        val myRetrofit : MyRetrofit
        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            myRetrofit = retrofit.create(MyRetrofit::class.java)
        }
}

//https://githubtrendingapi.docs.apiary.io/#reference/0/repositories/list-trending-repositories