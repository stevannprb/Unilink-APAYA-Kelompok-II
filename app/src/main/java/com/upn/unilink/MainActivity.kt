package com.upn.unilink

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Bikin variabel global biar bisa diakses untuk disembunyikan/dimunculkan
    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.bottomNavigation)

        // 1. SET HALAMAN PERTAMA KALI DIBUKA
        if (savedInstanceState == null) {
            hideBottomNav() // Sembunyikan menu bawah saat pertama kali buka app
            replaceFragment(splash())
        }

        // 2. LOGIKA KLIK MENU BAWAH (Hanya aktif setelah Login)
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_events -> {
                    replaceFragment(EventsFragment())
                    true
                }
                R.id.nav_add_post -> {
                    replaceFragment(AddPostFragment())
                    true
                }
                R.id.nav_connect -> {
                    // ✅ INI YANG DIUBAH: Garis miring dihapus dan panggil Connect()
                    replaceFragment(connect())
                    true
                }
                R.id.nav_alerts -> {
                    replaceFragment(AlertsFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi untuk ganti halaman (bisa dipanggil dari dalam Fragment juga)
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Fungsi untuk menyembunyikan Menu Bawah
    fun hideBottomNav() {
        bottomNavigation.visibility = View.GONE
    }

    // Fungsi untuk memunculkan Menu Bawah (Dipanggil setelah berhasil Login)
    fun showBottomNav() {
        bottomNavigation.visibility = View.VISIBLE
    }
}