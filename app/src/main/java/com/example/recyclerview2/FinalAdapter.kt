package com.example.recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview2.databinding.ItemviewBinding

class FinalAdapter(
    private val list: List<MainActivity.Info>,
    private val listener: (Int) -> Unit
): RecyclerView.Adapter<FinalAdapter.FinalViewHolder>() {

    class FinalViewHolder(
        val binding: ItemviewBinding,
        private val listener: (Int) -> Unit
    ) : ViewHolder(binding.root){

        fun settingData(model: MainActivity.Info){
            binding.txtTitle.text = model.Title
            binding.txtDescription.text = model.Description
            binding.root.setOnClickListener{
                listener.invoke(position)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        val binding = ItemviewBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return FinalViewHolder(binding, listener)
    }
    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        holder.settingData(list.get(position))
    }
    override fun getItemCount(): Int {
        return list.size
    }
}