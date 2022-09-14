package com.example.fragmentlifecycle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etFirstName: EditText = requireActivity().findViewById(R.id.etFirstName)
        val etSecondName: EditText = requireActivity().findViewById(R.id.etSecondName)
        val etEmail: EditText = requireActivity().findViewById(R.id.etEmail)
        val btnSend: Button = requireActivity().findViewById(R.id.btnSend)

            btnSend.setOnClickListener {
                if (etFirstName.text.toString().isNotEmpty() &&
                    etSecondName.text.toString().isNotEmpty() &&
                    etEmail.text.toString().isNotEmpty()
                ) {
                    val bundle = bundleOf(
                        "firstName" to etFirstName.text.toString(),
                        "secondName" to etSecondName.text.toString(),
                        "email" to etEmail.text.toString()
                    )
                    parentFragmentManager.beginTransaction().replace(R.id.container, SecondFragment(bundle))
                        .commit()
                }
            }
    }
}