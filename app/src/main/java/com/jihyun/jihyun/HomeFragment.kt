package com.jihyun.jihyun

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jihyun.jihyun.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding)

    private var myMusicList = listOf(
        Music(
            R.drawable.music_image_omg,
            "Ditto",
            "NewJeans"
        ),
        Music(
            R.drawable.music_image_omg,
            "OMG",
            "NewJeans"
        ),
        Music(
            R.drawable.music_image_newjeans,
            "Hype boy",
            "NewJeans"
        ),
        Music(
            R.drawable.music_image_anti,
            "ANTIFRAGILE",
            "LE SSERAFIM (르세라핌)"
        ),
        Music(
            R.drawable.music_image_newjeans,
            "Attention",
            "NewJeans"
        ),
        Music(
            R.drawable.music_image_afterlike,
            "After LIKE",
            "IVE (아이브)"
        ),
        Music(
            R.drawable.music_image_ilove,
            "Nxde",
            "(여자)아이들"
        ),
        Music(
            R.drawable.music_image_lovedive,
            "LOVE DIVE",
            "IVE (아이브)"
        ),
        Music(
            R.drawable.music_image_newjeans,
            "Cookie",
            "NewJeans"
        ),
        Music(
            R.drawable.music_image_ynwa,
            "봄날",
            "방탄소년단"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MusicAdapter(requireContext())
        binding.rvMusic.adapter = adapter
        adapter.setMusicList(myMusicList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}