package com.example.batuguntingkertas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
        FragmentLP1(),
        FragmentLP2(),
        FragmentLP3()
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

}