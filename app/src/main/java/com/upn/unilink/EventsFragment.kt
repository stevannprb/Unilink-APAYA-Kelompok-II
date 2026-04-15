package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.unilink.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {

    private var _binding: FragmentEventsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Logika Klik Tombol Banner Biru (Spotlight)
        binding.btnJoinSpotlight.setOnClickListener {
            Toast.makeText(requireContext(), "Mendaftar ke Annual Global Tech Symposium 2024!", Toast.LENGTH_SHORT).show()
        }
        // Logika klik tombol Notify Me
        binding.btnNotifyMe.setOnClickListener {
            val email = binding.etStudentEmail.text.toString()
            if (email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                android.widget.Toast.makeText(requireContext(), "Berhasil! Kami akan mengirimkan update ke: $email", android.widget.Toast.LENGTH_SHORT).show()
                binding.etStudentEmail.text.clear() // Bersihkan kolom input
            } else {
                android.widget.Toast.makeText(requireContext(), "Tolong masukkan email yang valid", android.widget.Toast.LENGTH_SHORT).show()
            }
        }

        // 2. Persiapan Data Dummy untuk RecyclerView
        val dummyEvents = listOf(
            Event("1", "Python for Data Science", "DataSci Club", "NOV", "26", "45 Seats left", "Room 402, Engineering"),
            Event("2", "Sustainability Summit", "Green Campus", "NOV", "28", "10:00 AM", "Main Quad"),
            Event("3", "Resume Masterclass", "Career Center", "DEC", "02", "Filling fast!", "Online (Zoom)", true),
            Event("4", "Alumni Mixer: CS '20", "Networking", "DEC", "05", "18:30 PM", "Student Lounge")
        )

        // 3. Pasang Adapter ke RecyclerView
        val eventAdapter = EventAdapter(dummyEvents)
        binding.rvEvents.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}