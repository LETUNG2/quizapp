package com.example.thibanglaixe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_question.*
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val userName=intent.getStringExtra(setData.name)
        val score=intent.getStringExtra(setData.score)
        val totalQuestion=intent.getStringExtra("total size")
        val time123=intent.getStringExtra(setData.time12)

        congratulations.text="Congratulations ${userName} !!"
        Score.text="${score} / ${totalQuestion}"
        time12.text="thời gian thi là: ${time123}"

        button.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))

            finish()
        }


    }
}