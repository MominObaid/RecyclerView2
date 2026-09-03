package com.example.recyclerview2

import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {
    @GET("/users")
    suspend fun getUsers(): Response<GithubUser>
}