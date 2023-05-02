package com.example.recyclerview2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)   
        setContentView(binding.root)

        val MainList = binding.itemList
        MainList.layoutManager = LinearLayoutManager(this)

        val newVal = listOf<Info>(
            Info("User 1" , "You may have a new message"),
            Info("User 2", "You may have a new message"),
            Info("User 3", "You may have a new message"),
            Info("User 4", "You may have a new message"),
            Info("User 5", "You may have a new message"),
            Info("User 6", "You may have a new message"),
            Info("User 7", "You may have a new message"),
            Info("User 8", "You may have a new message"),
            Info("User 9", "You may have a new message"),
            Info("User 10", "You may have a new message"),
            Info("User 11", "You may have a new message")
        )
        MainList.adapter = FinalAdapter( newVal, listener = {
            val title = newVal.get(it).Title
            Toast.makeText(this, "$title Clicked", Toast.LENGTH_SHORT).show()
        })

    }

  class Info(
        val Title : String = "",
        val Description : String = "",
    )
}
