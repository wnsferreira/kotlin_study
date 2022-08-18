package com.infnet.relacionamento_entre_entidades

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    val fragments = arrayOf(
        FornecedoresFragment(),
        ContatosFragment(),
        ProdutoFragment())

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}
