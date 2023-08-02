package com.example.score

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class YourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nightModeEnabled = true
        val version2Enabled = true

            if (nightModeEnabled) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                recreate()
            } else if (version2Enabled) {
                setContentView(R.layout.activity_your_version2)
            } else {
                setContentView(R.layout.activity_your)
            }

        // Initialize and set up your activity here
    }
}


class MainActivity : AppCompatActivity() {

    private var team1Score = 0
    private var team2Score = 0
    private var customScoreIncrement = 1

    private lateinit var team1ScoreTextView: TextView
    private lateinit var team2ScoreTextView: TextView
    private lateinit var customScoreIncrementEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        team1ScoreTextView = findViewById(R.id.team1ScoreTextView)
        team2ScoreTextView = findViewById(R.id.team2ScoreTextView)
        customScoreIncrementEditText = findViewById(R.id.customScoreIncrementEditText)
    }

    fun increaseScoreTeam1(view: View) {
        team1Score += customScoreIncrement
        updateTeam1Score()
    }

    fun decreaseScoreTeam1(view: View) {
        if (team1Score >= customScoreIncrement) {
            team1Score -= customScoreIncrement
            updateTeam1Score()
        }
    }

    fun increaseScoreTeam2(view: View) {
        team2Score += customScoreIncrement
        updateTeam2Score()
    }

    fun decreaseScoreTeam2(view: View) {
        if (team2Score >= customScoreIncrement) {
            team2Score -= customScoreIncrement
            updateTeam2Score()
        }
    }

    private fun updateTeam1Score() {
        team1ScoreTextView.text = team1Score.toString()
    }

    private fun updateTeam2Score() {
        team2ScoreTextView.text = team2Score.toString()
    }

    fun updateCustomScoreIncrement(view: View) {
        val incrementText = customScoreIncrementEditText.text.toString()
        if (incrementText.isNotEmpty()) {
            customScoreIncrement = incrementText.toInt()
        }
    }
}
