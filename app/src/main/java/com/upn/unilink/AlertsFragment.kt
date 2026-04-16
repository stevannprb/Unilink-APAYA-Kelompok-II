package com.upn.unilink

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.unilink.databinding.FragmentAlertsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class AlertsFragment : Fragment() {

    private var _binding: FragmentAlertsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data contoh - Using android.R.drawable as placeholders for missing local drawables
        val alertList = listOf(
            Alert(1, "Maya Chen", "Requested to connect with you...",
                "Requested to connect with you. You both share Advanced Algorithms and Data Structures in the same class.\n\nMau terima permintaan koneksi ini?",
                "2m ago", android.R.drawable.ic_menu_camera),

            Alert(2, "Mentor Feedback", "Dr. Sarah Jenkins left a comment...",
                "Dr. Sarah Jenkins left a comment on your Portfolio Draft:\n\"Excellent case study structure, let's refine the conclusion and add more visuals.\"",
                "1h ago", android.R.drawable.ic_menu_agenda),

            Alert(3, "Tech Mixer 2024", "IEEE Student Branch invited you...",
                "IEEE Student Branch invited you to a networking event this Friday at The Quad Engineering South Building.\n\n18:00 - 20:00",
                "4h ago", android.R.drawable.ic_menu_share),

            Alert(4, "Post Engagement", "Alex Rivera and 8 others liked...",
                "Alex Rivera and 8 others liked your post \"Preparing for the Career Fair\" in the Student Forum.",
                "8h ago", android.R.drawable.ic_menu_my_calendar),

            Alert(5, "System Update", "Spring 2025 registration starts...",
                "Spring 2025 registration starts tomorrow at 8:00 AM.\nPastikan advisor kamu sudah approve rencana studi.",
                "1d ago", android.R.drawable.ic_dialog_info)
        )

        val adapter = AlertsAdapter(alertList) { alert ->
            showAlertDetail(alert)
        }

        binding.recyclerAlerts.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerAlerts.adapter = adapter

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        Toast.makeText(requireContext(), "RecyclerView Alerts siap ✅", Toast.LENGTH_SHORT).show()
    }

    private fun showAlertDetail(alert: Alert) {
        MaterialAlertDialogBuilder(requireContext())
            .setIcon(alert.iconRes)
            .setTitle(alert.title)
            .setMessage(alert.fullMessage + "\n\n⏰ " + alert.time)
            .setPositiveButton("Tutup") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("Tandai Dibaca") { _, _ ->
                Toast.makeText(requireContext(), "${alert.title} ditandai sudah dibaca", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
