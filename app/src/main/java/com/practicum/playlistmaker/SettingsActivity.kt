package com.practicum.playlistmaker

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class SettingsActivity : ComponentActivity() {
    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val back = findViewById<Button>(R.id.back)
        val share = findViewById<Button>(R.id.share)
        val support = findViewById<Button>(R.id.write_to_support)
        val terms = findViewById<Button>(R.id.terms_of_use)

        back.setOnClickListener {
            finish()
        }

        share.setOnClickListener {
            val message = getString(R.string.share_internal_message)
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, message)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

        support.setOnClickListener {
            //val recipient = getString(R.string.email_to_support_recipient)
            val recipient = arrayOf(resources.getString(R.string.email_to_support_recipient))
            val theme = getString(R.string.email_to_support_theme)
            val body = getString(R.string.email_to_support_body)

              val supportIntent = Intent(Intent.ACTION_SENDTO).apply {
                  data = Uri.parse("mailto:")
                  putExtra(Intent.EXTRA_EMAIL, recipient)
                  putExtra(Intent.EXTRA_SUBJECT, theme)
                  putExtra(Intent.EXTRA_TEXT, body)
              }
              if (supportIntent.resolveActivity(packageManager) != null) {
                  startActivity(supportIntent)
              }
        }

        terms.setOnClickListener {
            val url = getString(R.string.terms_of_use)
            val webpage: Uri = Uri.parse(url)
            val termsIntent = Intent(Intent.ACTION_VIEW, webpage)
            if (termsIntent.resolveActivity(packageManager) != null) {
                startActivity(termsIntent)
            }
        }

    }
}
