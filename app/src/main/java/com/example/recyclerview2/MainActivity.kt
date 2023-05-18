package com.example.recyclerview2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.await

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FinalAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        getRepo()
    }
    companion object {
        var EDIT_USER_REQ_CODE = 100
        var ADD_USER_REQ_CODE = 200
    }

    private fun initRV() {
        val MainList = binding.itemList
        binding.itemList.layoutManager = LinearLayoutManager(this)
        MainList.adapter = FinalAdapter(newList,
            listener = {
                val title = newList.get(it).Title
                val description = newList.get(it).Description
                Toast.makeText(this, "$title is Clicked", Toast.LENGTH_SHORT).show()
                val newIntent = Intent(this, SecondActivity::class.java)
                newIntent.putExtra("editTitle",title)
                newIntent.putExtra("editDescrip", description)
                startActivity(newIntent)
//                Log.d("Obi", "Second activity started")
            },
            listener2 = {
                val check = newList.isEmpty()
//                val check2 =  newList.get(it)
//                Toast.makeText(this, "$check is Checked", Toast.LENGTH_SHORT).show()
//                Log.d("Obi", "Checked listener $check")
            })

        val addToList = binding.floatBtn
        addToList.setOnClickListener {
            Toast.makeText(this, "Opening Second activity", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            val mainModel = intent.getStringExtra("model")
            val position = intent.getIntExtra("position",-1)
            intent.putExtra("model", mainModel)
            intent.putExtra("position", position)
            startActivityForResult(intent, EDIT_USER_REQ_CODE)
            adapter.submitList(newList)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_USER_REQ_CODE && resultCode == RESULT_OK) {
            val model = data?.getParcelableExtra<itemList>("model")
            newList.add(model!!)
            adapter.notifyDataSetChanged()
        }
        if (requestCode == EDIT_USER_REQ_CODE && resultCode == RESULT_OK) {
            val position = data?.getIntExtra("position", -1) ?: -1
            val model = data?.getParcelableExtra<itemList>("model")

            if (model != null)
                newList.set(position, model)
            adapter.notifyItemChanged(position)
        }
        adapter.submitList(newList)
    }
    val newList = mutableListOf<itemList>(
        itemList("User 1", "You may have a new message",  false),
        itemList("User 2", "You may have a new message", false),
        itemList("User 3", "You may have a new message", false),
        itemList("User 4", "You may have a new message", false),
        itemList("User 5", "You may have a new message", false),
        itemList("User 6", "You may have a new message", false),
        itemList("User 7", "You may have a new message", false),
        itemList("User 8", "You may have a new message", false),
        itemList("User 9", "You may have a new message", false),
        itemList("User 10", "You may have a new message", false),
        itemList("User 11", "You may have a new message", false),
        itemList("User 12", "You may have a new message", false)
    )
    private fun getRepo(){
        val repo = MyRetrofitObj.myRetrofit.getRepos()
        CoroutineScope(Dispatchers.IO).launch {
            val result = repo.isExecuted
            if (result != null)
                Log.d("Obi ", "running")
        }
    }
}