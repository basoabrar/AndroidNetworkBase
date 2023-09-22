package com.example.latihanrv.detail.fetched.HomeAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.latihanrv.databinding.RvItemBinding
import com.example.latihanrv.model.Song
class SongListAdapter : ListAdapter<Song , SongListAdapter.SongViewHolder>(DiffCallback){


    override fun onCreateViewHolder (parent: ViewGroup , viewType: Int):
        SongListAdapter.SongViewHolder {
            return SongViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context)))
        }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class SongViewHolder(private var binding : RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (song: Song){
            binding.tvInfoTitle.text = song.title
            binding.tvPrice.text = song.performer
        }
    }
    companion object DiffCallback : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.id == newItem.id
        }
    }


}