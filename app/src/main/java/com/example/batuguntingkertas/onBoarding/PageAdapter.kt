package com.example.batuguntingkertas.onBoarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.batuguntingkertas.onBoarding.FragmentLP1
import com.example.batuguntingkertas.onBoarding.FragmentLP2
import com.example.batuguntingkertas.onBoarding.FragmentLP3

class PageAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
        FragmentLP1(),
        FragmentLP2(),
        FragmentLP3(),
        FragmentLogin()
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

}