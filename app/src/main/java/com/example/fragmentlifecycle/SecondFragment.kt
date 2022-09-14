package com.example.fragmentlifecycle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment(private val bundle: Bundle) : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvFirstName: TextView = requireActivity().findViewById(R.id.tvFirstName)
        val tvSecondName: TextView = requireActivity().findViewById(R.id.tvSecondName)
        val tvEmail: TextView = requireActivity().findViewById(R.id.tvEmail)
        val btnDelete: Button = requireActivity().findViewById(R.id.btnDelete)

        tvFirstName.text = bundle.getString("firstName")
        tvSecondName.text = bundle.getString("secondName")
        tvEmail.text = bundle.getString("email")

        btnDelete.setOnClickListener {
            tvFirstName.text = ""
            tvSecondName.text = ""
            tvEmail.text = ""
            parentFragmentManager.beginTransaction().replace(R.id.container, MainFragment()).commit()
        }
    }
}