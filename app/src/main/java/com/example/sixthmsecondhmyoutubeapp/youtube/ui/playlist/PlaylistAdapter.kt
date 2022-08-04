package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sixthmsecondhmyoutubeapp.databinding.ItemPlaylistBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Item
import com.example.sixthmsecondhmyoutubeapp.youtube.model.PlayList

class PlaylistAdapter(private var data: PlayList) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data.items[position])
    }

    override fun getItemCount(): Int {
        return data.items.size
    }


    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.image.load(item.snippet.thumbnails.default.url)
            binding.tvTitle.text = item.snippet.title
        }
    }
}