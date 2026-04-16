package com.upn.unilink

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.upn.unilink.databinding.ItemEventBinding

class EventAdapter(private val eventList: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    class EventViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        with(holder.binding) {
            tvMonth.text = event.tanggalBulan
            tvDate.text = event.tanggalAngka
            tvEventTitle.text = event.judulEvent
            tvLocation.text = event.lokasi
            tvTime.text = event.waktu

            // Tombol "Join" abu-abu diklik
            btnJoin.setOnClickListener {
                Toast.makeText(holder.itemView.context, "Join Event: ${event.judulEvent}", Toast.LENGTH_SHORT).show()
            }

            // Kartu ditekan (buka detail)
            root.setOnClickListener {
                Toast.makeText(holder.itemView.context, "Buka detail: ${event.judulEvent}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = eventList.size
}