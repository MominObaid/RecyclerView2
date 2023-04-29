package com.example.recyclerview2//package com.example.recyclerview2
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//
//
//class MainAdapter(val context: Context, val list: List<String>, val ItemListDscptn: List<String>) :
//    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val View = inflater.inflate(R.layout.itemview, parent, false)
//        return MainViewHolder(View)
//    }
//
//    override fun onBindViewHolder(holder : MainViewHolder, position: Int){
//        holder.ViewTitle.text = list[position]
//        holder.ViewDecription.text = list[position]
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//
//    }
//
//    class MainViewHolder(itemView: View) : ViewHolder(itemView) {
//        val ViewTitle = itemView.findViewById<TextView>(R.id.txtTitle)
//        val ViewDecription = itemView.findViewById<TextView>(R.id.txtDescription)
////
////        init {
////            ViewTitle = itemView.findViewById(R.id.txtTitle)
////        }
//    }
//}
