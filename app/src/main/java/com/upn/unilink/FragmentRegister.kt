package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.upn.unilink.databinding.FragmentRegisterBinding

class FragmentRegister : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // Ini penting ditambahkan

        // Logika tombol Register
        binding.btnRegister.setOnClickListener {
            val name = binding.nameInput.text.toString()
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()

            val selectedId = binding.genderGroup.checkedRadioButtonId
            val gender = when (selectedId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> ""
            }

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || gender.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Register berhasil", Toast.LENGTH_SHORT).show()
            }
        }

        // Logika tulisan "Login" ditekan
        binding.tvLogin.setOnClickListener {
            // Minta tolong MainActivity buat pindahin layarnya ke FragmentLogin
            (requireActivity() as MainActivity).replaceFragment(FragmentLogin())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}