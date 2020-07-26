package com.example.batuguntingkertas

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.batuguntingkertas.databinding.ActivityMainBinding

class GameLogic() {
    lateinit var binding: ActivityMainBinding

    fun select(image1:ImageView,image2:ImageView,image3:ImageView){
        image1.scaleX = 1.4F
        image1.scaleY = 1.4F
        image2.visibility = View.INVISIBLE
        image3.visibility = View.INVISIBLE
    }

    fun ulang(image1:ImageView,image2:ImageView,image3:ImageView){
        image1.scaleX = 1.0F
        image1.scaleY = 1.0F
        image2.visibility = View.VISIBLE
        image3.visibility = View.VISIBLE
    }


    fun versus(kamu:Int,lawan:Int):String {
        return if (kamu == 1) {
            if (lawan == 1) {
                Log.d ("Hasil", "Anda Seri")
                "Seri"
            }else if (lawan == 2){
                point.kamu = point.kamu + 10
                Log.d ("Hasil", "Anda Menang")
                "Menang"
            }else{
                point.lawan = point.lawan + 10
                Log.d ("Hasil", "Anda Kalah")
                "Kalah"
            }
        } else if (kamu == 2) {
            if (lawan == 1) {
                point.lawan = point.lawan + 10
                Log.d ("Hasil", "Anda Kalah")
                "Kalah"
            }else if (lawan == 2){
                Log.d ("Hasil", "Anda Seri")
                "Seri"
            }else{
                point.kamu = point.kamu + 10
                Log.d ("Hasil", "Anda Menang")
                "Menang"
            }
        } else {
            if (lawan == 1) {
                point.kamu = point.kamu + 10
                Log.d ("Hasil", "Anda Menang")
                "Menang"
            }else if (lawan == 2){
                point.lawan = point.lawan + 10
                Log.d ("Hasil", "Anda Kalah")
                "Kalah"
            }else{
                Log.d ("Hasil", "Anda Seri")
                "Seri"
            }
        }
    }



}