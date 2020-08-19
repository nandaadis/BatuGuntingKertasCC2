package com.example.batuguntingkertas.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.databinding.ActivityInfoBinding

class Info : AppCompatActivity() {

    lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener(){
            finish()
        }
    }
}