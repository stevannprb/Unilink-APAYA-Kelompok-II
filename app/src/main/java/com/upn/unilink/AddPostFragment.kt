package com.upn.unilink

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.upn.unilink.databinding.FragmentAddPostBinding
import java.util.Calendar

class AddPostFragment : Fragment() {

    private var _binding: FragmentAddPostBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Dropdowns
        val tipePekerjaan = arrayOf("Magang", "Full-time", "Part-time", "Volunteer")
        binding.cbJenisPekerjaan.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, tipePekerjaan))

        val posisi = arrayOf("Software Engineer", "Designer", "Marketing", "Data Analyst")
        binding.cbPosisi.setAdapter(ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, posisi))

        // Kalender Pop-up Mulai
        binding.etTanggalMulai.setOnClickListener {
            showDatePicker { date -> binding.etTanggalMulai.setText(date) }
        }

        // Kalender Pop-up Akhir
        binding.etTanggalAkhir.setOnClickListener {
            showDatePicker { date -> binding.etTanggalAkhir.setText(date) }
        }

        // Tombol Upload
        binding.btnUploadFile.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka penyimpanan...", Toast.LENGTH_SHORT).show()
            binding.tvNamaFile.text = "syarat_pendaftaran.pdf"
        }

        // Tombol Posting
        binding.btnPosting.setOnClickListener {
            val judul = binding.etJudul.text.toString()
            if (judul.isNotEmpty()) {
                Toast.makeText(requireContext(), "Berhasil memposting: $judul", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), "Judul wajib diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePicker(onDateSelected: (String) -> Unit) {
        val c = Calendar.getInstance()
        DatePickerDialog(requireContext(), { _, y, m, d ->
            onDateSelected("$d/${m + 1}/$y")
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}