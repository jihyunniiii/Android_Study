package com.jihyun.jihyun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.jihyun.jihyun.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding: FragmentGalleryBinding
        get() = requireNotNull(_binding)

    private var myAlbumList = listOf(
        Album(
            R.drawable.music_image_newjeans,
            "NewJeans 1st EP 'New Jeans'",
            "NewJeans"
        ),
        Album(
            R.drawable.music_image_anti,
            "ANTIFRAGILE",
            "LE SSERAFIM (르세라핌)"
        ),
        Album(
            R.drawable.music_image_ynwa,
            "YOU NEVER WALK ALONE",
            "방탄소년단"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AlbumAdapter(requireContext())
        binding.vpAlbum.adapter = adapter
        adapter.setAlbumList(myAlbumList)

        TabLayoutMediator(binding.tabAlbum, binding.vpAlbum)
        { tab, position -> }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}