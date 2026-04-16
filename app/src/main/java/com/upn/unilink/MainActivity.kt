package com.upn.unilink

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_events -> {
                    Toast.makeText(this, "Events", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_add_post -> {
                    Toast.makeText(this, "Add Post", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_connect -> {
                    Toast.makeText(this, "Connect", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_alerts -> {
                    Toast.makeText(this, "Alerts", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // Setup Category Chips
        val chipAll = findViewById<Chip>(R.id.chipAll)
        val chipInternships = findViewById<Chip>(R.id.chipInternships)
        val chipResearch = findViewById<Chip>(R.id.chipResearch)
        val chipClubs = findViewById<Chip>(R.id.chipClubs)
        val chipFeatured = findViewById<Chip>(R.id.chipFeatured)

        val chips = listOf(chipAll, chipInternships, chipResearch, chipClubs, chipFeatured)

        chips.forEach { chip ->
            chip.setOnClickListener {
                // Reset all chips to default style
                chips.forEach { c ->
                    c.isChecked = false
                    c.chipBackgroundColor = android.content.res.ColorStateList.valueOf(
                        when (c.id) {
                            R.id.chipAll, R.id.chipFeatured -> getColor(R.color.chip_default)
                            else -> getColor(R.color.chip_default_light)
                        }
                    )
                    c.setTextColor(getColor(R.color.chip_text_default))
                }
                // Set selected chip style
                chip.isChecked = true
                chip.chipBackgroundColor = android.content.res.ColorStateList.valueOf(
                    getColor(R.color.chip_selected)
                )
                chip.setTextColor(getColor(android.R.color.white))

                Toast.makeText(this, "Selected: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}