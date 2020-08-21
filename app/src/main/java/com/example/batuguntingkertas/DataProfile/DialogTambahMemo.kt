package com.example.batuguntingkertas.DataProfile

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ROOM.DatabaseMemo
import com.example.batuguntingkertas.ROOM.EntityMemo
import com.example.batuguntingkertas.onBoarding.FragmentLP1
import kotlinx.android.synthetic.main.dialog_memo.*
import kotlinx.android.synthetic.main.dialog_memo.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


class DialogTambahMemo : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    var DB: DatabaseMemo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.dialog_memo, container, false)

//        DB = DatabaseMemo.getInstance(this.requireContext())
//        var cal = Calendar.getInstance()
//
//        fun updateDateInView() {
//            val myFormat = "MM/dd/yyyy" // mention the format you need
//            val sdf = SimpleDateFormat(myFormat, Locale.US)
//            rootView.et_tanggal.setText(sdf.format(cal.getTime()))
//        }
//
//        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
//            override fun onDateSet(
//                view: DatePicker, year: Int, monthOfYear: Int,
//                dayOfMonth: Int
//            ) {
//                cal.set(Calendar.YEAR, year)
//                cal.set(Calendar.MONTH, monthOfYear)
//                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//                updateDateInView()
//            }
//        }
//
//        rootView.et_tanggal!!.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View) {
//                DatePickerDialog(
//                    this@DialogTambahMemo.requireContext(),
//                    dateSetListener,
//                    // set DatePickerDialog to point to today's date when it loads up
//                    cal.get(Calendar.YEAR),
//                    cal.get(Calendar.MONTH),
//                    cal.get(Calendar.DAY_OF_MONTH)
//                ).show()
//            }
//
//        })
//
//        rootView.btn_negative.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                dismiss()
//            }
//        })
//
//        rootView.btn_positive.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(v: View?) {
//                val objek = EntityMemo(
//                    null,
//                    rootView.et_tanggal.text.toString(),
//                    rootView.et_isimemo.text.toString()
//                )
//
//                GlobalScope.launch {
//                    DB?.DaoMemo()?.insert(objek)
//                }
//            }
//        })

        return rootView
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cal = Calendar.getInstance()

        fun updateDateInView() {
            val myFormat = "MM/dd/yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            et_tanggal.setText(sdf.format(cal.getTime()))
        }

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        et_tanggal!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@DialogTambahMemo.requireContext(),
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })


        val main = activity as DataProfileActivity

        val Db = DatabaseMemo.getInstance(main)

        btn_negative.setOnClickListener {
            main.fetchData()
            dismiss()

        }

        btn_positive.setOnClickListener {
            val objek = EntityMemo(
                null,
                et_tanggal.text.toString(),
                et_isimemo.text.toString()
            )

            GlobalScope.launch {
                Db?.DaoMemo()?.insert(objek)
            }

            view?.let { activity?.hideKeyboard(it) }

            main.fetchData()
            dismiss()

        }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
