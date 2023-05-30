package com.example.recyclerview2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GithubRepository (private val githubApi: GithubApi){
    private val _usersList = MutableLiveData<GithubUser>()
    val usersList : LiveData<GithubUser>
    get() = _usersList

    suspend fun getUsers(){ //viewModel will call this fun to get data here data is list of Users
        val result = githubApi.getUsers()
        if (result != null){
            _usersList.value = result.body()
        }
    }
}