package com.example.batuguntingkertas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.batuguntingkertas.DataProfile.DataProfileActivity
import com.example.batuguntingkertas.game.point
import com.example.batuguntingkertas.game.vsKomputerActivity
import com.example.batuguntingkertas.game.vsPemainActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val sharedPreferences = getSharedPreferences(
            getString(R.string.shared_preference),
            Context.MODE_PRIVATE
        )
        val name = sharedPreferences.getString("Username", "Sabrina")

        Glide.with(this).load(R.drawable.landing_page1).into(menu_img1)
        Glide.with(this).load(R.drawable.landing_page2).into(menu_img2)

        menu_text1.text = "$name vs Pemain"
        menu_text2.text = "$name vs CPU"
        point.kamu = 0
        point.lawan = 0

        iv_person.setOnClickListener {
            val intent = Intent(this, DataProfileActivity::class.java)
            startActivity(intent)
        }

        menu_img2.setOnClickListener(){
            val intent = Intent(this, vsKomputerActivity::class.java)
            val bundle = Bundle()

            bundle.putString("nama", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        menu_text2.setOnClickListener(){
            val intent = Intent(this, vsKomputerActivity::class.java)
            val bundle = Bundle()

            bundle.putString("nama", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        menu_img1.setOnClickListener(){
            val intent = Intent(this, vsPemainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("nama", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        menu_text1.setOnClickListener(){
            val intent = Intent(this, vsPemainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("nama", name)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}