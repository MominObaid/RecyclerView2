package com.example.recyclerview2

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null
//    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

//        val ItemList : List<String> = listOf("aaaa", "bbbb", "cccc", "dddd", "eeeee" , "ffff", "ggggg")
//        val mainList = findViewById<RecyclerView>(R.id.itemList)
//        mainList.adapter = MainAdapter(this, ItemList, ItemListDscptn)
//        mainList.layoutManager = LinearLayoutManager(this)

        val MainList = findViewById<RecyclerView>(R.id.itemList)
        MainList.adapter = FinalAdapter(listOf
            (
            Info("User 8" , "You may have a new message"),
            Info("User 7", "You may have a new message"),
            Info("User 1", "You may have a new message"),
            Info("User 2", "You may have a new message"),
            Info("User 3", "You may have a new message"),
            Info("User 4", "You may have a new message"),
            Info("User 5", "You may have a new message"),
            Info("User 6", "You may have a new message"),
            Info("User 9", "You may have a new message"),
            Info("User 10", "You may have a new message"),
            Info("User 11", "You may have a new message")
        ), listener = {

        })
        MainList.layoutManager = LinearLayoutManager(this)
    }


  class Info(
        val Title : String = "",
        val Description : String = "",
//        val ImageV : ImageView


    )
}