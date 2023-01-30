package com.jihyun.jihyun

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.jihyun.databinding.ItemGalleryBinding

class AlbumAdapter(context: Context) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var albumList: List<Album> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemGalleryBinding.inflate(inflater, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.onBind(albumList[position])
    }

    fun setAlbumList(albumList: List<Album>) {
        this.albumList = albumList.toList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = albumList.size

    class AlbumViewHolder(
        private val binding: ItemGalleryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Album) {
            binding.ivItemGalleryImage.setImageDrawable(binding.root.context.getDrawable(data.albumImage))
            binding.tvItemGalleryAlbumName.text = data.albumName
            binding.tvItemGallerySingerName.text = data.singerName
        }
    }
}