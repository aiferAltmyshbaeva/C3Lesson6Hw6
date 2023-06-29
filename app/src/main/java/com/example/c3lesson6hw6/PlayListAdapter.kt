package com.example.c3lesson6hw6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.c3lesson6hw6.databinding.ItemPlaylistBinding

class PlayListAdapter (
    val list: ArrayList<PlayList>,
    val onItemClickListener: OnItemClickListener

        ): Adapter<PlayListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(private val binding: ItemPlaylistBinding): RecyclerView.ViewHolder(binding.root){
    fun bind() = with(binding){
        val item = list[adapterPosition]
        item.apply {
            tvNumber.text = indexNumber.toString()
            tvSongTitle.text = songTitle
            tvSingerName.text = singer
            tvLength.text = songLength
        }
        itemView.setOnClickListener { onItemClickListener.onItemClick(adapterPosition) }
    }
    }
}