package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView // Wajib ditambahkan agar ImageView terbaca
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Baris ini memanggil file fragment_home.xml
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Cari gambar/icon profil berdasarkan ID-nya di fragment_home.xml
        // ⚠️ PENTING: Cek file fragment_home.xml kamu. Kalau ID gambar profilnya bukan "ivProfile",
        // tolong ganti tulisan R.id.ivProfile di bawah ini sesuai dengan ID aslimu ya!
        val iconProfile = view.findViewById<ImageView>(R.id.ivProfile)

        // 2. Berikan aksi klik untuk pindah ke ProfileFragment
        iconProfile?.setOnClickListener {
            // Minta tolong MainActivity buat pindahin layarnya ke ProfileFragment
            (requireActivity() as MainActivity).replaceFragment(ProfileFragment())
        }
    }
}