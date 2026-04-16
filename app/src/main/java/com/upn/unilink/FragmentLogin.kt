package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.upn.unilink.databinding.FragmentLoginBinding

class FragmentLogin : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logika saat tombol Login ditekan
        binding.btnLogin.setOnClickListener {
            val email = binding.emailInput.text.toString()
            if (email.isNotEmpty()) {
                Toast.makeText(context, "Welcome back, $email", Toast.LENGTH_SHORT).show()

                // 1. Panggil MainActivity
                val mainActivity = requireActivity() as MainActivity

                // 2. Munculkan kembali Menu Navigasi Bawah!
                mainActivity.showBottomNav()

                // 3. Pindah ke halaman Home
                mainActivity.replaceFragment(HomeFragment())

            } else {
                binding.emailLayout.error = "Please enter your email"
            }
        }

        // Sekalian aku tambahin logika buat tulisan Register di bawah
        // Biar kalau user salah pencet, dia bisa balik ke halaman Register
        binding.tvRegister.setOnClickListener {
            (requireActivity() as MainActivity).replaceFragment(FragmentRegister())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}