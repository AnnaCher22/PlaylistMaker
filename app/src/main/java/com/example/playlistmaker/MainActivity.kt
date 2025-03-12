package com.example.playlistmaker


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search = findViewById<Button>(R.id.searchButton)
        val media = findViewById<Button>(R.id.media)
        val settings = findViewById<Button>(R.id.settings)

        search.setOnClickListener {
            val intentSearch = Intent(this, SearchActivity::class.java)
            startActivity(intentSearch)
        }
        media.setOnClickListener {
            val intentMedia = Intent(this, MediaActivity::class.java)
            startActivity(intentMedia)
        }
        settings.setOnClickListener {
            val intentSettings = Intent(this, SettingsActivity::class.java)
            startActivity(intentSettings)
        }
    }
}