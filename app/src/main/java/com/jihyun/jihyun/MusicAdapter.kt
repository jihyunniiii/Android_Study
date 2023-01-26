package com.jihyun.jihyun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jihyun.jihyun.databinding.ItemMusicBinding
import android.content.Context

class MusicAdapter(context: Context) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var musicList: List<Music> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = ItemMusicBinding.inflate(inflater, parent, false)
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(musicList[position])
    }

    override fun getItemCount(): Int = musicList.size

    fun setMusicList(musicList: List<Music>) {
        this.musicList = musicList.toList()
        notifyDataSetChanged()
    }

    class MusicViewHolder(
        private val binding: ItemMusicBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Music) {
            binding.ivItemMusicImage.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvItemMusicName.text = data.musicName
            binding.tvItemSingerName.text = data.singerName
        }
    }
}