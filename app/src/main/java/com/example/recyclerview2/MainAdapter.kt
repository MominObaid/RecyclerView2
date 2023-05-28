package com.example.recyclerview2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.recyclerview2.databinding.AdItemViewBinding
import com.example.recyclerview2.databinding.ItemviewBinding

class myDiffUtil : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return false
//        oldItem.Title == newItem.Title || oldItem.Description == newItem.Description
    }
}

class MainAdapter(
    val list: MutableList<Any>,
    private val itemListener: (Int) -> Unit,
    private val checkListener: (Boolean) -> Unit,
) : ListAdapter<Any, ViewHolder>(myDiffUtil()) {

    inner class ItemViewHolder(
        val binding: ItemviewBinding,
        private val itemListener: (Int) -> Unit,
        private val checkListener: (Boolean) -> Unit,
    ) : ViewHolder(binding.root) {

        fun bindItem(model: itemList) {
            Glide.with(binding.ivIcon).load(model.item_image).into(binding.ivIcon)
            binding.tvTitle.text = model.Title
            binding.tvDescription.text = model.Description
            binding.root.setOnClickListener {
                itemListener.invoke(position)
            }
            binding.cbChecked.isChecked = model.checked
            binding.cbChecked.setOnCheckedChangeListener { buttonView, isChecked ->
                val msg = if (isChecked) "Checked" else "Unchecked"
                Log.d("Obi", "$msg")
//                Toast.makeText(this, "${msg}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class AdViewHolder(
        var binding: AdItemViewBinding,
    ) : ViewHolder(binding.root) {

        fun bindAd(model: itemList2) {
            Glide.with(binding.imageViewAd).load(model.adImage).into(binding.imageViewAd)
            binding.textviewAd.text = model.adText
        }
    }

    companion object {
        val ITEM_VIEW = 1
        val AD_VIEW = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ItemviewBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        val adBinding =
            AdItemViewBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)

        return if (viewType == ITEM_VIEW) {
            ItemViewHolder(itemBinding, itemListener, checkListener)
        } else AdViewHolder(adBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         if(holder is ItemViewHolder) {
            holder.bindItem(list.get(position)as itemList)
        }else if (holder is AdViewHolder)
            holder.bindAd(list.get(position)as itemList2)
    }

    override fun getItemViewType(position: Int): Int {
        val lists = list[position]
        return when (lists){
            is itemList -> ITEM_VIEW
            else -> AD_VIEW
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }
}
