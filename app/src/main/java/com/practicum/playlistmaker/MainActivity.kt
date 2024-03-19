package com.practicum.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val search = findViewById<Button>(R.id.search)
        val mediaLibrary = findViewById<Button>(R.id.media_library)
        val settings = findViewById<Button>(R.id.settings)

        search.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }
        mediaLibrary.setOnClickListener {
            val mediaLibraryIntent = Intent(this, MediaLibraryActivity::class.java)
            startActivity(mediaLibraryIntent)
        }
        settings.setOnClickListener {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
        }

        val searchClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val searchIntent = Intent(this@MainActivity, SearchActivity::class.java)
                startActivity(searchIntent)
            }
        }
        val mediaLibraryClickListener: View.OnClickListener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                val mediaLibraryIntent = Intent(this@MainActivity, MediaLibraryActivity::class.java)
                startActivity(mediaLibraryIntent)
            }
        }


        search.setOnClickListener(searchClickListener)
        mediaLibrary.setOnClickListener(mediaLibraryClickListener)
    }
}
