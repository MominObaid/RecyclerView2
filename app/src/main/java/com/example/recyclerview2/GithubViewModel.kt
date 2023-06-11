package com.example.recyclerview2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class GithubViewModel(private val githubRepository: GithubRepository) : ViewModel() {

   init {
       viewModelScope.launch {
           githubRepository.getUsers()
           
       }
    }

    val users : LiveData<GithubUser>
    get() = githubRepository.usersList

    class GithubViewModelFactory(private val repository: GithubRepository): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GithubViewModel(repository) as T
        }
    }
//    override fun <T: ViewModel?> create(modelClass: Class<T>):T{

//    }
//    val usersList: LiveData<List<GithubUser>> = MutableLiveData<List<GithubUser>>()
//    private val _usersList = MutableLiveData<List<GithubUser>>()
//    val usersList : LiveData<List<GithubUser>>
//    get() = _usersList
//
//    suspend fun getUsers(){
//        val result = GithubApi.getUsers()
//        _usersList.postValue(result.body())
//    }
//     fun getGithubUsers() {
//        val githubApiObj = GithubApiObj.getInstance()
//        val service = githubApiObj.create(GithubApi::class.java)
//        viewModelScope.launch {
////            val response = service.getUsers()
////            val result = response.body()
////            if (result != null)
////                _usersList.value
////            _usersList.postValue()
//                Log.d("Obi", "Running")
//        }
//    }
}
