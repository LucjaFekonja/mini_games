package com.example.tictactoe

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game)

        val selectedImageId = intent.getIntExtra("selectedImage", 0)

        // Initialize your game with the selected image
        val gameTextView: TextView = findViewById(R.id.gameTextView)
        gameTextView.text = "Game Started with image: $selectedImageId"
    }
}
