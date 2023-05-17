package com.example.tablayoutproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayoutproject.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fragList =
        listOf(FragmentBirds.newInstance(), FragmentCat.newInstance(), FragmentDog.newInstance())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manageTabs()

    }

    fun manageTabs(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeholder, fragList[0]).commit()

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.placeholder, fragList[tab?.position!!]).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }
}