package com.example.recyclerview2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubViewModel() : ViewModel() {

//
//   init {
//        getGithubUsers()
//    }
    val usersList: LiveData<List<GithubUser>> = MutableLiveData<List<GithubUser>>()

     fun getGithubUsers() {
        val githubApiObj = GithubApiObj.getInstance()
        val service = githubApiObj.create(GithubApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getUsers() //unnececary
            val result = response.body()
            if (result != null)
                Log.d("Obi","VM Running")

//            val result = githubApiObj.getUsers()
//            if (result != null)
//            Log.d("Obi",result.body().toString())
                Log.d("Obi", "Running")
        }
    }
}