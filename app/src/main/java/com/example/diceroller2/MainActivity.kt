package com.example.diceroller2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val rollButtonMA: Button = findViewById(R.id.button_AM)
        rollDiceMA()
        rollButtonMA.setOnClickListener {
            rollDiceMA()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun rollDiceMA() {
        val diceMA = DiceMA(numSidesMA = 6)
        val dice2 = DiceMA(numSidesMA = 6)

        val cubeRoll = diceMA.rollMA()
        val cubeRoll2 = dice2.rollMA()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView3)
        val totalText: TextView = findViewById(R.id.textView) // grab your textView

        // update dice images
        val diceImages = listOf(
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
        )

        diceImage.setImageResource(diceImages[cubeRoll - 1])
        diceImage2.setImageResource(diceImages[cubeRoll2 - 1])

        // calculate total and update the text
        val total = cubeRoll + cubeRoll2
        totalText.text = "Total: $total"
    }

    class DiceMA(val numSidesMA: Int) {
        fun rollMA(): Int {
            return (1..numSidesMA).random()
        }
    }
}
