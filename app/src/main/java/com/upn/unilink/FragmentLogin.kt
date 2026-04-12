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

        // Login Button Action
        binding.btnLogin.setOnClickListener {
            val email = binding.emailInput.text.toString()
            if (email.isNotEmpty()) {
                Toast.makeText(context, "Welcome back, $email", Toast.LENGTH_SHORT).show()
            } else {
                binding.emailLayout.error = "Please enter your email"
            }
        }

        // Navigation to Register (Contoh)
        binding.tvRegister.setOnClickListener {
            // Logika pindah fragment register
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}