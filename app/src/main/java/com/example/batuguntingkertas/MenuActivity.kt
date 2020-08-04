package com.example.batuguntingkertas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.fragment_l_p3.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Glide.with(this).load(R.drawable.landing_page1).into(menu_img1)
        Glide.with(this).load(R.drawable.landing_page2).into(menu_img2)

        val bundle = intent.extras
        val name = bundle?.getString("nama")

        menu_text1.text = "$name vs Pemain"
        menu_text2.text = "$name vs CPU"

        menu_img2.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("nama", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        menu_text2.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("nama", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        menu_img1.setOnClickListener(){
            Toast.makeText(
                this,
                "Pilihan ini belum tersedia, nunggu developernya semangat",
                Toast.LENGTH_SHORT
            ).show()
        }

        menu_text1.setOnClickListener(){
            Toast.makeText(
                this,
                "Pilihan ini belum tersedia, nunggu developernya semangat",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}