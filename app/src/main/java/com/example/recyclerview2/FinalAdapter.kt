package com.example.recyclerview2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.recyclerview2.databinding.ItemviewBinding

//var myUtill : DiffUtil()  //1

class FinalAdapter(
    private val list: List<itemList>,
    private val listener: (Int) -> Unit,
    private val listener2: (Int) -> Unit
) : RecyclerView.Adapter<FinalAdapter.FinalViewHolder>() {

//) : ListAdapter<itemList, FinalViewHolder>()  //2

    class FinalViewHolder(
        val binding: ItemviewBinding,
        private val listener: (Int) -> Unit,
        private val listener2: (Int) -> Unit
    ) : ViewHolder(binding.root) {

        fun settingData(model: itemList) {
            binding.tvTitle.text = model.Title
            binding.tvDescription.text = model.Description
            binding.root.setOnClickListener {
                listener.invoke(position)
            }
        }
        fun settingData2(model: itemList){
            binding.cbChecked.isChecked = model.checked
            binding.cbChecked.setOnClickListener{ //TODO try setOnCheckedChange
                listener2.invoke(position)
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
    }

    override fun getItemCount(): Int {
        return list.size
    }
}