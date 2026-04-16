package com.upn.unilink

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upn.unilink.databinding.ItemAlertBinding   // ← GANTI JADI INI

class AlertsAdapter(
    private val alerts: List<Alert>,
    private val onClick: (Alert) -> Unit
) : RecyclerView.Adapter<AlertsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemAlertBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAlertBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = alerts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alert = alerts[position]

        holder.binding.tvTitle.text = alert.title
        holder.binding.tvMessage.text = alert.message
        holder.binding.tvTime.text = alert.time
        holder.binding.imgIcon.setImageResource(alert.iconRes)

        holder.itemView.setOnClickListener {
            onClick(alert)
        }
    }
}