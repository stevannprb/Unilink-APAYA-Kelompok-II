package com.upn.unilink

data class Alert(
    val id: Int,
    val title: String,
    val message: String,      // teks pendek di list
    val fullMessage: String,  // teks lengkap di detail
    val time: String,
    val iconRes: Int          // ikon foto profil
)