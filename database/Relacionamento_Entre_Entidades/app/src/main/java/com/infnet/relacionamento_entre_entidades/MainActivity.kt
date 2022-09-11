package com.infnet.relacionamento_entre_entidades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        -------------------------------------------------

        var tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        var viewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.adapter = TabAdapter(this)
        TabLayoutMediator(tabLayout, viewPager2){ tab, position ->
            viewPager2.setCurrentItem(tab.position, true)
//            if (position == 2) tab.setText("Produtos")
            if (position == 1) tab.setText("Contatos")
            if (position == 0) tab.setText("Fornecedores")
        }.attach()

    }
}