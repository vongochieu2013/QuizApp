package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Delete the top toolbar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_math_start.setOnClickListener{
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MathQuestionsActivity::class.java)
                intent.putExtra(MathConstants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }

        btn_flag_start.setOnClickListener{
            if (et_name.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, FlagQuestionsActivity::class.java)
                intent.putExtra(FlagConstants.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish() //close current activity
            }
        }
    }
}