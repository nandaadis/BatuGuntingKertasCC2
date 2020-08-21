package com.example.batuguntingkertas.DataProfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ROOM.DatabaseMemo
import com.example.batuguntingkertas.ROOM.EntityMemo
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {
    var DB: DatabaseMemo? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        DB = DatabaseMemo.getInstance(this)

        btn_positive.setOnClickListener {
            val objectBelanjaan = EntityMemo(
                null,
                et_tanggal.text.toString(),
                et_isimemo.text.toString()
            )

            GlobalScope.launch {
                val result = DB?.DaoMemo()?.insert(objectBelanjaan)
                runOnUiThread {
                    if (result != 0.toLong()) {
                        //sukses
                        Toast.makeText(
                            this@AddActivity, "Sukses menambahkan ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        //gagal
                        Toast.makeText(
                            this@AddActivity, "Gagal menambahkan ",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    finish()
                }

            }
        }
    }
}