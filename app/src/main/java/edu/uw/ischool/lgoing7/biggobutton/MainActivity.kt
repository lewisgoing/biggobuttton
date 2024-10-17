package edu.uw.ischool.lgoing7.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var pushButton: Button
    private var pushCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        pushButton = findViewById(R.id.pushButton) // link var to actual button
        pushButton.setOnClickListener {
            onPushButtonClick()
        }
    }

    private fun onPushButtonClick() {
        pushCount++
        updateButtonText()
        changeColors()
    }

    private fun updateButtonText() {
        val timeString = if (pushCount == 1) "time" else "times"
        pushButton.text = "You have pushed me $pushCount $timeString!"
    }

    private fun changeColors() {
        pushButton.setBackgroundColor(getRandomColor())
        pushButton.setTextColor(getRandomColor())
    }

    private fun getRandomColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }


}