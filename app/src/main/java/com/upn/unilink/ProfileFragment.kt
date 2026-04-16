package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.google.android.material.card.MaterialCardView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kita panggil MainActivity sekali di awal biar gampang dipake ke bawahnya
        val mainActivity = requireActivity() as MainActivity

        // MANTAP! Langsung sembunyikan menu bawah saat masuk halaman Profile
        mainActivity.hideBottomNav()

        // 1. Logika Tombol Back (Balik ke Home)
        val btnBack = view.findViewById<ImageView>(R.id.btnBackToHome)
        btnBack?.setOnClickListener {
            // Munculin lagi menu bawahnya, lalu pindah ke Home
            mainActivity.showBottomNav()
            mainActivity.replaceFragment(HomeFragment())
        }

        // 2. Logika Tombol Notifications (Pindah ke halaman Alerts)
        val btnNotif = view.findViewById<MaterialCardView>(R.id.btnNotifications)
        btnNotif?.setOnClickListener {
            // Munculin lagi menu bawahnya, lalu pindah ke Alerts
            mainActivity.showBottomNav()
            mainActivity.replaceFragment(AlertsFragment())
        }

        // 3. Logika Tombol Sign Out (Balik ke Welcome)
        val btnSignOut = view.findViewById<MaterialCardView>(R.id.btnSignOut)
        btnSignOut?.setOnClickListener {
            // Tetap sembunyikan menu bawahnya, lalu pindah ke Welcome
            mainActivity.hideBottomNav()
            mainActivity.replaceFragment(WelcomeFragment())
        }
    }
}