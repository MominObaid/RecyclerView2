package com.example.recyclerview2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.recyclerview2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addTitle = binding.etTitle
        val addDescription = binding.etDescription
        Glide.with(binding.ivEdit).load(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcx6ujIsNIbVvB929ruxl5Hnd8i304r-3JNJY_rojDNQ&s")
            .into(binding.ivEdit)
        val addBtn = binding.btnAdd
        val model: itemList? = intent?.getParcelableExtra("model")
        addTitle.setText(model?.Title ?: "")
        addDescription.setText(model?.Description ?: "")

        addBtn.text = if (model != null)
            "Update" else "Add"

        val position = intent.getIntExtra("position", -1)
        addBtn.setOnClickListener {
            val fileTitle: String = addTitle.text.toString()
            val fileDescrip: String = addDescription.text.toString()
            val itemModel = if (model == null) itemList() else model
            itemModel.Title = fileTitle
            itemModel.Description = fileDescrip

            val intent = Intent()
            intent.putExtra("model", itemModel)
            intent.putExtra("position", position)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}