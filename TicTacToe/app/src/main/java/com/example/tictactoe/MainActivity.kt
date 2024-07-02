package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.CharacterSelectionActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: ImageButton = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            val intent = Intent(this@MainActivity, CharacterSelectionActivity::class.java)
            startActivity(intent)
        }
    }
}
