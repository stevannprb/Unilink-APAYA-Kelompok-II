package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menyambungkan dengan file desain XML fragment_welcome
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Cari tombol "Sign In" berdasarkan ID-nya di XML (btnGetStarted)
        val btnSignIn = view.findViewById<Button>(R.id.btnGetStarted)

        // 2. Berikan aksi ketika tombol tersebut diklik
        btnSignIn.setOnClickListener {
            // Memanggil fungsi replaceFragment di MainActivity untuk pindah ke FragmentRegister
            (requireActivity() as MainActivity).replaceFragment(FragmentRegister())
        }
    }
}