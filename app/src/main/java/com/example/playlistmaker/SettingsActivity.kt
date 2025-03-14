package com.example.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.back)
        val shareButton = findViewById<Button>(R.id.theme_switcher2)
        val supportButton = findViewById<Button>(R.id.theme_switcher3)
        val termsButton = findViewById<Button>(R.id.theme_switcher4)

        // Возвращаемся назад без создания нового MainActivity
        backButton.setOnClickListener {
            finish()
        }

        // Кнопка "Поделиться приложением"
        shareButton.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text))
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share)))
        }

        // Кнопка "Написать в поддержку"
        supportButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = "mailto:".toUri()
                putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.support_email)))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject))
                putExtra(Intent.EXTRA_TEXT, getString(R.string.email_body))
            }
            startActivity(Intent.createChooser(emailIntent, getString(R.string.write_support)))
        }

        // Кнопка "Пользовательское соглашение"
        termsButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.terms_url)))
            startActivity(browserIntent)
        }
    }
}

