package com.jihyun.jihyun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jihyun.jihyun.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        changeFragment(HomeFragment())

        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home_home -> {
                    changeFragment(HomeFragment())
                }
                R.id.item_home_gallery -> {
                    changeFragment(GalleryFragment())
                }
                R.id.item_home_search -> {
                    changeFragment(SearchFragment())
                }
            }
            true
        }
    }

    private fun changeFragment(fragment: Fragment) {
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.home_container, fragment)
            .commit()
    }
}