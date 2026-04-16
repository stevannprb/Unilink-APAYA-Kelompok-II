package com.upn.unilink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class connect : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Cukup panggil layout fragment_connect.xml aja di sini
        return inflater.inflate(R.layout.fragment_connect, container, false)
    }
}