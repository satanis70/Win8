package com.example.win8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.example.win8.databinding.ActivityMainBinding
import com.example.win8.repository.TermsRepository
import com.example.win8.service.ApiInterface
import com.example.win8.viewmodel.TermsViewModel
import com.example.win8.viewmodel.TermsViewModelFactory
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {

    var count = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(Util.ONE_SIGNAL_KEY)

        val context = this

        binding.btnTerms.setOnClickListener {
            startActivity(Intent(this, TermsActivity::class.java))
        }
        binding.btnTeamsStats.setOnClickListener {
            startActivity(Intent(this, TeamsActivity::class.java))
        }
        binding.btnPlayers.setOnClickListener {
            startActivity(Intent(this, PlayersActivity::class.java))
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                count+=1
                Toast.makeText(context,"Please click BACK again to exit", Toast.LENGTH_SHORT).show()
                if (count==2){
                    context.finish()
                }
            }
        })
    }

}