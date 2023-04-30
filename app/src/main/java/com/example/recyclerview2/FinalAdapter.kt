package com.example.recyclerview2

import android.content.Context
import android.icu.text.CaseMap.Title
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview2.databinding.ActivityMainBinding.inflate
import com.example.recyclerview2.databinding.ItemviewBinding
import org.w3c.dom.Text

class FinalAdapter(
    private val list: List<MainActivity.Info>,
   private val listener : (Int) -> Unit
): RecyclerView.Adapter<FinalAdapter.FinalViewHolder>() {

    class FinalViewHolder(
        val binding: ItemviewBinding,
       private val listener: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root){
        fun settingData(model: ViewModel){
            binding.txtTitle.text = model.toString()
           binding.root.setOnClickListener{
               listener.invoke(position)
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        val binding = ItemviewBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return FinalViewHolder(binding)

//        val inflater = LayoutInflater.from(parent.context)
//       val view = inflater.inflate(R.layout.itemview, parent, false)
//        return FinalViewHolder(view)
    }

    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.txtTitle.text = Title
                binding.txtDescription.text = Description
                binding.imgIcon.context
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
