package com.example.recyclerview2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        GithubViewModel()
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
            val position = data?.getIntExtra("position", 1)?: 1
            val model = data?.getParcelableExtra<itemList?>("model")

            if (model != null) {
                newList.set(position,model)
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
}