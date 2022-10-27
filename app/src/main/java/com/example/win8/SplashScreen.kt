package com.example.win8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.win8.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val progressBar = binding.progressHorizontalBar
        var currentProgress = 0
        val context = this
        progressBar.max = 300
        object : CountDownTimer(3000, 1000){
            override fun onTick(p0: Long) {
                currentProgress+=100
                progressBar.progress = currentProgress
            }

            override fun onFinish() {
                startActivity(Intent(context, MainActivity::class.java))
                finish()
            }

        }.start()
    }
}