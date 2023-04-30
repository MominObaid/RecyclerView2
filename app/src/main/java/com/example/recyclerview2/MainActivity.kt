package com.example.recyclerview2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

//    private var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val ItemList : List<String> = listOf("aaaa", "bbbb", "cccc", "dddd", "eeeee" , "ffff", "ggggg")
//        val mainList = findViewById<RecyclerView>(R.id.itemList)
//        mainList.adapter = MainAdapter(this, ItemList, ItemListDscptn)
//        mainList.layoutManager = LinearLayoutManager(this)

        val MainList = findViewById<RecyclerView>(R.id.itemList)
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
            newVal.get(it).Title
            Toast.makeText(this, "${newVal.get(it).Title} Clicked", Toast.LENGTH_SHORT).show()
        })

    }

  class Info(
        val Title : String = "",
        val Description : String = "",
//        val ImageV : ImageView


    )
}