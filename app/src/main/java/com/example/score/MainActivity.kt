package com.example.score

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast



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
            }

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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //For menu visibility
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {

                return true
            }
            //For click responses
            R.id.action_settings ->
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                showAboutInfo()
                return true
            }
            // Handle other menu items if needed
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showAboutInfo() {
        val developerInfo = "Developer: Your Name\nCourse: Your Course Code"
        Toast.makeText(this, developerInfo, Toast.LENGTH_LONG).show()
    }
}
override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.action_about -> {
            showAboutInfo()
            return true
        }
        R.id.action_settings -> {
            val settingsIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingsIntent)
            return true
        }
        else -> return super.onOptionsItemSelected(item)
    }
}

fun showAboutInfo() {
    TODO("Not yet implemented")
}


