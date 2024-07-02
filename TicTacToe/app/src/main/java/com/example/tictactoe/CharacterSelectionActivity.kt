package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.R

class CharacterSelectionActivity : AppCompatActivity() {

    private var selectedImageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.character_selection)

        val imageView1: ImageView = findViewById(R.id.characterX)
        val imageView2: ImageView = findViewById(R.id.characterO)
        val continueButton: ImageButton = findViewById(R.id.continueButton)

        imageView1.setOnClickListener {
            selectedImageId = R.id.characterX
            imageView1.alpha = 0.5f // Highlight the selected image
            imageView2.alpha = 1.0f // Deselect the other image
        }

        imageView2.setOnClickListener {
            selectedImageId = R.id.characterO
            imageView1.alpha = 1.0f
            imageView2.alpha = 0.5f
        }

        continueButton.setOnClickListener {
            if (selectedImageId != 0) {
                val intent = Intent(this@CharacterSelectionActivity, GameActivity::class.java)
                intent.putExtra("selectedImage", selectedImageId)
                startActivity(intent)
            }
        }
    }
}
