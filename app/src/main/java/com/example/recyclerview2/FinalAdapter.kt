package com.example.recyclerview2

import android.app.Application
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview2.databinding.ItemviewBinding

class myDiffUtil : DiffUtil.ItemCallback<itemList>(){
    override fun areItemsTheSame(oldItem: itemList, newItem: itemList): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: itemList, newItem: itemList): Boolean {
        return if (oldItem.Title != newItem.Title && oldItem.Description != newItem.Description)
            true
        else (oldItem.Title == newItem.Title && oldItem.Description == newItem.Description)
        false
    }
}
class FinalAdapter(
    private val list: List<itemList>,
    private val listener: (Int) -> Unit,
    private val listener2: (Boolean) -> Unit
) : ListAdapter<itemList , FinalAdapter.FinalViewHolder>(myDiffUtil()){

    class FinalViewHolder(
        val binding: ItemviewBinding,
        private val listener: (Int) -> Unit,
        private val listener2: (Boolean) -> Unit
    ) : ViewHolder(binding.root) {

        fun settingData(model: itemList) {
            binding.tvTitle.text = model.Title
            binding.tvDescription.text = model.Description
            binding.root.setOnClickListener {
                listener.invoke(position)
            }
        }
        fun settingData2(model: itemList) {
            binding.cbChecked.isChecked = model.checked
            binding.cbChecked.setOnCheckedChangeListener { buttonView, isChecked ->
                val msg = if (isChecked) "Checked" else "Unchecked"
                Log.d("Obi", "$msg")
//                Toast.makeText(this, "$msg", Toast.LENGTH_SHORT).show()
            }
            binding.cbChecked.setOnClickListener {
                listener2.invoke(true)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinalViewHolder {
        val binding = ItemviewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return FinalViewHolder(binding, listener, listener2)
    }

    override fun onBindViewHolder(holder: FinalViewHolder, position: Int) {
        holder.settingData(list.get(position))
        holder.settingData2(list.get(position))
        Log.d("Obi" , "created $position")

    }

    override fun getItemCount(): Int {
        return list.size
    }
//    override fun getItemViewType(position: Int): Int {
//        return super.getItemViewType(position)
//
//    }
}