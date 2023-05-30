package com.example.recyclerview2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.databinding.ActivityMainBinding
import com.example.recyclerview2.databinding.ItemviewBinding
import retrofit2.create
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    lateinit var githubViewModel: GithubViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        observer()
    }

    fun observer() {
        val githubApiObj = GithubApiObj.getInstance().create(GithubApi::class.java)
        val repository = GithubRepository(githubApiObj)
        githubViewModel = ViewModelProvider(
            this, GithubViewModel.GithubViewModelFactory(repository))
            .get(GithubViewModel::class.java)

        githubViewModel.users.observe(this) {
            Log.d("Obi", it.toString())
        }
    }

    companion object {
        var EDIT_USER_REQ_CODE = 100
        var ADD_USER_REQ_CODE = 200
    }

    private fun initRV() {
        val mainAdapter = binding.itemList
        binding.itemList.layoutManager = LinearLayoutManager(this)

        adapter = MainAdapter(itemListener = {
            val title = newList.get(it)
//            val description = newList.get(it).Description
            Toast.makeText(this, "$title is Clicked", Toast.LENGTH_SHORT).show()
            val newintent = Intent(this, SecondActivity::class.java)
            newintent.putExtra("model", newList.get(it) as itemList) //replaced with newList.get(it)
            newintent.putExtra("position", it)
            startActivityForResult(newintent, EDIT_USER_REQ_CODE)
            adapter.submitList(newList.toMutableList())

        }, checkListener = {
//                val check2 =  newList.get().Title
//                Log.d("Obi", "Checked listener $check")
        })
        mainAdapter.adapter = adapter
        adapter.submitList(newList.toMutableList())

        val addToList = binding.floatBtn
        addToList.setOnClickListener {
            Toast.makeText(this, "Opening Second activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            val mainModel = intent.getStringExtra("model")
            val position = intent.getIntExtra("position", -1)
            intent.putExtra("model", mainModel)
            intent.putExtra("position", position)
            startActivityForResult(intent, ADD_USER_REQ_CODE)
            adapter.submitList(newList.toMutableList())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_USER_REQ_CODE && resultCode == RESULT_OK) {
            val model = data?.getParcelableExtra<itemList>("model")
            newList.add(model!!)
            adapter.submitList(newList.toMutableList())

        }
        if (requestCode == EDIT_USER_REQ_CODE && resultCode == RESULT_OK) {
            val position = data?.getIntExtra("position", 1) ?: 1
            val model = data?.getParcelableExtra<itemList?>("model")

            if (model != null) {
                newList.set(position, model)
//                newList.removeAt(position)
            }
            adapter.submitList(newList.toMutableList())
        }
    }

    val newList = mutableListOf<Any>(
        itemList("User", "Details"),
        itemList("User 1", "You may have a new message"),
        itemList("User 2", "You may have a new message"),
        itemList2("Advertise 1"),
        itemList("User 3", "You may have a new message"),
        itemList("User 4", "You may have a new message"),
        itemList("User 5", "You may have a new message"),
        itemList2("Advertise 2"),
        itemList("User 6", "You may have a new message"),
        itemList("User 7", "You may have a new message"),
        itemList("User 8", "You may have a new message"),
        itemList2("Advertise 3"),
        itemList("User 9", "You may have a new message"),
        itemList("User 10", "You may have a new message"),
        itemList("User 11", "You may have a new message"),
        itemList2("Advertise 4"),
        itemList("User 13", "You may have a new message"),
        itemList("User 14", "You may have a new message"),
        itemList("User 15", "You may have a new message"),
        itemList2("Advertise 5"),
        itemList("User 16", "You may have a new message"),
        itemList("User 17", "You may have a new message"),
        itemList("User 18", "You may have a new message"),
        itemList2("Advertise 6"),
        itemList("User 19", "You may have a new message"),
        itemList("User 20", "You may have a new message"),
        itemList("User 21", "You may have a new message")
    )
//
//    override fun onItemClick(onClickListener: Unit) {
//    }
//
//    override fun onCheckBoxClick() {
//        TODO("Not yet implemented")
//    }
}
//token 29-5-23 :
// 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