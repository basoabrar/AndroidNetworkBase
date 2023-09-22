//package com.example.latihanrv
//
//import android.annotation.SuppressLint
//import android.media.Image
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.latihanrv.databinding.RvItemBinding
//import kotlin.math.log
//
//class ListAdapter(private val viewModel : RvViewModel) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding  = RvItemBinding.inflate(inflater)
//        return ViewHolder(binding)
//    }
//
////    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
////        val item = viewModel.menu.value!![position]
////
////        holder.tv_title.text = item.title
////        holder.img_view.setImageResource(item.image)
////        holder.tv_price.text = item.price.toString()
////
////        holder.btn_delete.setOnClickListener {
////            deleteItem(position)
////        }
////
////    }
//
//    override fun getItemCount(): Int {
//        return viewModel.menu.value!!.size
//    }
//
//    fun addItem(newData : Makanan){
//        viewModel.menu.value!!.add(newData)
//        notifyItemInserted(viewModel.menu.value!!.size - 1) //index
//    }
//
//
//    fun deleteItem(position: Int){
//        if( position in 0 until viewModel.menu.value!!.size){
//            viewModel.menu.value!!.removeAt(position)
//            notifyItemRemoved(position)
////            notifyItemRangeChanged(position , viewModel.menu.value!!.size - position)
//            Log.i("datarv", viewModel.menu.value!!.size.toString())
//            Log.i("datarv", position.toString())
//
//        }
//    }
//
//    class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
//        var tv_title : TextView = binding.tvInfoTitle
//        var img_view : ImageView = binding.imageView
//        var tv_price : TextView = binding.tvPrice
//        var btn_delete : ImageView = binding.icDelete
//    }
//}