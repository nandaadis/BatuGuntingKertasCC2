package com.example.batuguntingkertas.onBoarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batuguntingkertas.R
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        vp_landingpage.adapter =
            PageAdapter(
                supportFragmentManager
            )

    }
}