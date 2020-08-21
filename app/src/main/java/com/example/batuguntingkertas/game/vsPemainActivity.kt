package com.example.batuguntingkertas.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.databinding.ActivityVsKomputerBinding
import com.example.batuguntingkertas.databinding.ActivityVsPemainBinding

class vsPemainActivity : AppCompatActivity() {

    var kamu:Int = 0
    var lawan:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vs_pemain)
        val binding = ActivityVsPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val gamelogic = GameLogic(binding.yourRock, binding.yourScissor, binding.yourPapper, binding.oppRock, binding.oppScissor, binding.oppPapper, binding.status, binding.restart, binding.ulang, binding.yourPoint, binding.oppPoint)


        binding.yourPoint.text = "Point : ${point.kamu}"
        binding.oppPoint.text = "Point : ${point.lawan}"
        val bundle = intent.extras
        val name = bundle?.getString("nama")
        binding.yourName.text = name
        binding.oppName.text = "Pemain 2"

        binding.info.setOnClickListener(){
            startActivity(Intent(this,Info::class.java))
        }

        binding.home.setOnClickListener(){
            finish()
            point.kamu = 0
            point.lawan = 0
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
        }

        binding.exit.setOnClickListener() {
            System.exit(0);
        }

        binding.restart.setOnClickListener() {
            point.kamu = 0
            point.lawan = 0
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
        }

        Glide.with(this).load(R.drawable.batu).into(binding.yourRock)
        Glide.with(this).load(R.drawable.gunting).into(binding.yourScissor)
        Glide.with(this).load(R.drawable.kertas).into(binding.yourPapper)
        Glide.with(this).load(R.drawable.batu).into(binding.oppRock)
        Glide.with(this).load(R.drawable.gunting).into(binding.oppScissor)
        Glide.with(this).load(R.drawable.kertas).into(binding.oppPapper)

        fun result(nilai1:Int,nilai2:Int){
            if(nilai1>0 && nilai2>0){
                val hasil = gamelogic.versus(kamu,lawan)
                gamelogic.hasilversus(hasil)

                binding.ulang.setOnClickListener {
                    gamelogic.pickyou(kamu)
                    gamelogic.ulang()
                    gamelogic.pickopp(lawan)
                    gamelogic.ulang()
                    gamelogic.diulang()
                    kamu = 0
                    lawan = 0
                }
            }
        }

        binding.yourRock.setOnClickListener {
            kamu = 1
            gamelogic.pickyou(kamu)
            gamelogic.select()
            result(kamu,lawan)
        }

        binding.yourScissor.setOnClickListener {
            kamu = 2
            gamelogic.pickyou(kamu)
            gamelogic.select()
            result(kamu,lawan)
        }

        binding.yourPapper.setOnClickListener {
            kamu = 3
            gamelogic.pickyou(kamu)
            gamelogic.select()
            result(kamu,lawan)
        }

        binding.oppRock.setOnClickListener {
            lawan = 1
            gamelogic.pickopp(lawan)
            gamelogic.select()
            result(kamu,lawan)
        }

        binding.oppScissor.setOnClickListener {
            lawan = 2
            gamelogic.pickopp(lawan)
            gamelogic.select()
            result(kamu,lawan)
        }

        binding.oppPapper.setOnClickListener {
            lawan = 3
            gamelogic.pickopp(lawan)
            gamelogic.select()
            result(kamu,lawan)
        }
    }
}