package com.example.batuguntingkertas.DataProfile

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ROOM.DatabaseMemo
import com.example.batuguntingkertas.ROOM.EntityMemo
import kotlinx.android.synthetic.main.activity_data_profile.*
import kotlinx.android.synthetic.main.dialog_memo.*
import kotlinx.android.synthetic.main.fragment_login.et_username
import kotlinx.android.synthetic.main.rv_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable.cancel
import kotlinx.coroutines.launch

class DataProfileActivity : AppCompatActivity() {

    private var Db: DatabaseMemo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_profile)

        Db = DatabaseMemo.getInstance(this)

        val sharedPreferences = getSharedPreferences(
            getString(R.string.shared_preference),
            Context.MODE_PRIVATE
        )

        val Email = sharedPreferences.getString("Email", "sabrina@binar.co.id")
        val Username = sharedPreferences.getString("Username", "Sabrina")
        et_email.setText(Email)
        et_username.setText(Username)
        et_email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                var emailbaru = et_email.text.toString()
                sharedPreferences.edit().putString("Email", emailbaru).apply()
            }
        })

        et_username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                var usernamebaru = et_username.text.toString()
                sharedPreferences.edit().putString("Username", usernamebaru).apply()
            }
        })

        iv_back.setOnClickListener() {
            finish()
        }

        fab_addmemo.setOnClickListener() {
            val fm=supportFragmentManager
            val MyFragment=DialogTambahMemo()
            MyFragment.show(fm, "Fragment")

//            val keActivityAdd = Intent(this, AddActivity::class.java)
//            startActivity(keActivityAdd)
        }


        fetchData()
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData() {
        GlobalScope.launch {
            val listMemo = Db?.DaoMemo()?.getAll()

            runOnUiThread {
                listMemo?.let {
                    val adapter = MemoAdapter(it)
                    val layoutManager =
                        LinearLayoutManager(
                            this@DataProfileActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                    recycleview_memo.layoutManager = layoutManager
                    recycleview_memo.adapter = adapter
                }

            }
        }
    }

    fun addData(objek : EntityMemo) {
        GlobalScope.launch {
            Db?.DaoMemo()?.insert(objek)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        DatabaseMemo.destroyInstance()
    }


}


