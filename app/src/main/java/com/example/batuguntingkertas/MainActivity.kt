package com.example.batuguntingkertas

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.databinding.ActivityMainBinding
import com.example.batuguntingkertas.databinding.ActivityMainBinding.inflate
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        var gamelogic = GameLogic()

        binding.yourPoint.text = "Point : ${point.kamu}"
        binding.oppPoint.text = "Point : ${point.lawan}"

        val bundle = intent.extras
        val name = bundle?.getString("nama")

        your_name.text = name

        home.setOnClickListener(){
            finish()
            point.kamu = 0
            point.lawan = 0
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
        }

        exit.setOnClickListener() {
            System.exit(0);
        }

        //Restart Button
        binding.restart.setOnClickListener() {
            point.kamu = 0
            point.lawan = 0
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
        }

        //Rock Button
        binding.yourRock.setOnClickListener() {
            val kamu = 1
            Log.d ("Pilihan", "Kamu memilih batu")
            var you:ImageView = binding.yourRock
            var youhilang1 = binding.yourPapper
            var youhilang2 = binding.yourScissor

            var lawan = binding.oppRock
            var hilang1 = binding.oppPapper
            var hilang2 = binding.oppScissor

            var random:Int = (1..3).random()


            when(random) {
                1 -> {
                    lawan = binding.oppRock
                    hilang1 = binding.oppPapper
                    hilang2 = binding.oppScissor
                }
                2 -> {
                    lawan = binding.oppScissor
                    hilang1 = binding.oppPapper
                    hilang2 = binding.oppRock
                }
                3 -> {
                    lawan = binding.oppPapper
                    hilang1 = binding.oppRock
                    hilang2 = binding.oppScissor
                }
            }

            gamelogic.select(you,youhilang1,youhilang2)
            gamelogic.select(lawan,hilang1,hilang2)
            var text:String = gamelogic.versus(kamu,random)
            binding.status.text = "$text"
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
            binding.restart.visibility = View.INVISIBLE

            var btnulang = binding.ulang
            btnulang.visibility = View.VISIBLE
            binding.ulang.setOnClickListener(){
                gamelogic.ulang(you,youhilang1,youhilang2)
                gamelogic.ulang(lawan,hilang1,hilang2)
                btnulang.visibility = View.INVISIBLE
                binding.status.text = "VS"
                binding.restart.visibility = View.VISIBLE
                binding.yourRock.isClickable = true
            }

            binding.yourRock.isClickable = false

        }

        //Scissor Button
        binding.yourScissor.setOnClickListener() {
            val kamu = 2
            Log.d ("Pilihan", "Kamu memilih gunting")
            var you:ImageView = binding.yourScissor
            var youhilang1 = binding.yourPapper
            var youhilang2 = binding.yourRock

            var lawan = binding.oppRock
            var hilang1 = binding.oppPapper
            var hilang2 = binding.oppScissor

            var random:Int = (1..3).random()


            when(random) {
                1 -> {
                    lawan = binding.oppRock
                    hilang1 = binding.oppPapper
                    hilang2 = binding.oppScissor
                }
                2 -> {
                    lawan = binding.oppScissor
                    hilang1 = binding.oppPapper
                    hilang2 = binding.oppRock
                }
                3 -> {
                    lawan = binding.oppPapper
                    hilang1 = binding.oppRock
                    hilang2 = binding.oppScissor
                }
            }

            gamelogic.select(you,youhilang1,youhilang2)
            gamelogic.select(lawan,hilang1,hilang2)
            var text:String = gamelogic.versus(kamu,random)
            binding.status.text = "$text"
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
            binding.restart.visibility = View.INVISIBLE

            var btnulang = binding.ulang
            btnulang.visibility = View.VISIBLE
            binding.ulang.setOnClickListener(){
                gamelogic.ulang(you,youhilang1,youhilang2)
                gamelogic.ulang(lawan,hilang1,hilang2)
                btnulang.visibility = View.INVISIBLE
                binding.status.text = "VS"
                binding.restart.visibility = View.VISIBLE
                binding.yourScissor.isClickable = true
            }

            binding.yourScissor.isClickable = false
        }

        //Papper Button
        binding.yourPapper.setOnClickListener() {
            val kamu = 3
            Log.d ("Pilihan", "Kamu memilih kertas")
            var you:ImageView = binding.yourPapper
            var youhilang1 = binding.yourScissor
            var youhilang2 = binding.yourRock

            var lawan = binding.oppRock
            var hilang1 = binding.oppPapper
            var hilang2 = binding.oppScissor

            var random:Int = (1..3).random()


            when(random) {
                1 -> {
                    lawan = binding.oppRock
                    hilang1 = binding.oppPapper
                    hilang2 = binding.oppScissor
                }
                2 -> {
                    lawan = binding.oppScissor
                    hilang1 = binding.oppPapper
                    hilang2 = binding.oppRock
                }
                3 -> {
                    lawan = binding.oppPapper
                    hilang1 = binding.oppRock
                    hilang2 = binding.oppScissor
                }
            }

            gamelogic.select(you,youhilang1,youhilang2)
            gamelogic.select(lawan,hilang1,hilang2)
            var text:String = gamelogic.versus(kamu,random)
            binding.status.text = "$text"
            binding.yourPoint.text = "Point : ${point.kamu}"
            binding.oppPoint.text = "Point : ${point.lawan}"
            binding.restart.visibility = View.INVISIBLE

            var btnulang = binding.ulang
            btnulang.visibility = View.VISIBLE
            binding.ulang.setOnClickListener(){
                gamelogic.ulang(you,youhilang1,youhilang2)
                gamelogic.ulang(lawan,hilang1,hilang2)
                btnulang.visibility = View.INVISIBLE
                binding.status.text = "VS"
                binding.restart.visibility = View.VISIBLE
                binding.yourPapper.isClickable = true
            }

            binding.yourPapper.isClickable = false
        }

        binding.info.setOnClickListener(){
            startActivity(Intent(this,Info::class.java))
        }


        Glide.with(this).load(R.drawable.batu).into(your_rock)
        Glide.with(this).load(R.drawable.gunting).into(your_scissor)
        Glide.with(this).load(R.drawable.kertas).into(your_papper)
        Glide.with(this).load(R.drawable.batu).into(opp_rock)
        Glide.with(this).load(R.drawable.gunting).into(opp_scissor)
        Glide.with(this).load(R.drawable.kertas).into(opp_papper)


    }
}