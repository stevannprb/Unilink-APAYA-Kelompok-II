package com.upn.unilink

data class Event(
    val id: String,
    val judulEvent: String,
    val penyelenggara: String,
    val tanggalBulan: String,
    val tanggalAngka: String,
    val waktu: String,
    val lokasi: String,
    val isFillingFast: Boolean = false
)