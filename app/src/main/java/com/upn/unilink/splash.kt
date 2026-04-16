package com.upn.unilink

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class splash : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menyambungkan dengan file desain XML splash kamu
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bikin timer untuk pindah halaman otomatis
        Handler(Looper.getMainLooper()).postDelayed({

            // Ngecek biar gak error kalau user udah close app sebelum 3 detik
            if (isAdded && activity != null) {
                // Perintah untuk pindah ke halaman Welcome
                (requireActivity() as MainActivity).replaceFragment(WelcomeFragment())
            }

        }, 3000) // 3000 = 3 detik
    }
}