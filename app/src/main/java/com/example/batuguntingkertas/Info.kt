package com.example.batuguntingkertas

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.batuguntingkertas.databinding.ActivityInfoBinding
import com.example.batuguntingkertas.databinding.ActivityMainBinding

class Info : AppCompatActivity() {

    lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}