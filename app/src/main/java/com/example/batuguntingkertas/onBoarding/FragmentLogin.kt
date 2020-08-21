package com.example.batuguntingkertas.onBoarding

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.batuguntingkertas.MenuActivity
import com.example.batuguntingkertas.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLogin.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLogin : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = getActivity()!!.getSharedPreferences(
            getString(R.string.shared_preference),
            Context.MODE_PRIVATE
        )

        btn_login.setOnClickListener {
            val Username = sharedPreferences.getString("Username", "Sabrina")
            val Password = sharedPreferences.getString("Password", "binar123")
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            view?.let { activity?.hideKeyboard(it) }

            if (username.isEmpty() && password.isEmpty()) {
                Snackbar.make(
                    it, // Parent view
                    "Username dan Password harus diisi", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            } else if (username == Username && password == Password) {
                val intent = Intent(activity, MenuActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(
                    it, // Parent view
                    "Username dan password tidak terdaftar", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
                ).show()
            }
        }

        btn_reset.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("Username", "Sabrina")
            editor.putString("Password", "binar123")
            editor.apply()
        }
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentLogin.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentLogin().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}