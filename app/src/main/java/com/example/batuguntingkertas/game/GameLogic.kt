package com.example.batuguntingkertas.game

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class GameLogic(val imageyou1: ImageView,val imageyou2: ImageView, val imageyou3: ImageView, val imageopp1: ImageView, val imageopp2: ImageView, val imageopp3: ImageView, var status: TextView, var restart: Button, var ulang: Button, var yourPoint: TextView, var oppPoint: TextView) {
    var image1 = imageyou1
    var image2 = imageyou2
    var image3 = imageyou3

    fun pickyou(number:Int){
        when(number) {
            1 -> {
                image1 = imageyou1
                image2 = imageyou2
                image3 = imageyou3
            }
            2 -> {
                image1 = imageyou2
                image2 = imageyou1
                image3 = imageyou3
            }
            3 -> {
                image1 = imageyou3
                image2 = imageyou2
                image3 = imageyou1
            }
        }
        image1.isClickable = false
    }

    fun pickopp(number:Int){
        when(number) {
            1 -> {
                image1 = imageopp1
                image2 = imageopp2
                image3 = imageopp3
            }
            2 -> {
                image1 = imageopp2
                image2 = imageopp1
                image3 = imageopp3
            }
            3 -> {
                image1 = imageopp3
                image2 = imageopp2
                image3 = imageopp1
            }
        }
        image1.isClickable = false
    }

    fun select(){
        image1.scaleX = 1.4F
        image1.scaleY = 1.4F
        image2.visibility = View.INVISIBLE
        image3.visibility = View.INVISIBLE
        image1.isClickable = false
    }

    fun ulang(){
        image1.scaleX = 1.0F
        image1.scaleY = 1.0F
        image2.visibility = View.VISIBLE
        image3.visibility = View.VISIBLE
        image1.isClickable = true
    }


    fun versus(kamu:Int,lawan:Int):String {
        ulang.visibility = View.VISIBLE

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

    fun hasilversus(hasil:String){
        status.text = "$hasil"
        yourPoint.text = "Point : ${point.kamu}"
        oppPoint.text = "Point : ${point.lawan}"
        restart.visibility = View.INVISIBLE
    }

    fun diulang() {
        ulang.visibility = View.INVISIBLE
        status.text = "VS"
        restart.visibility = View.VISIBLE
    }



}