package com.example.win8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win8.adapters.PlayersAdapter
import com.example.win8.adapters.TeamsAdapter
import com.example.win8.databinding.ActivityPlayersBinding
import com.example.win8.databinding.ActivityTeamsBinding
import com.example.win8.model.Rating
import com.example.win8.repository.PlayersRepository
import com.example.win8.service.ApiInterface
import com.example.win8.viewmodel.PlayersViewModel
import com.example.win8.viewmodel.PlayersViewModelFactory

class PlayersActivity : AppCompatActivity() {
    lateinit var binding: ActivityPlayersBinding
    lateinit var playersViewModel: PlayersViewModel
    var list: ArrayList<Rating> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface = Util.getInstance().create(ApiInterface::class.java)
        val playersRepository = PlayersRepository(apiInterface)

        playersViewModel = ViewModelProvider(
            this,
            PlayersViewModelFactory(playersRepository)
        ).get(PlayersViewModel::class.java)
        playersViewModel.players.observe(this) {

            for (i in it.rating){
                list.add(i)
            }
            initRecyclerView()
        }
    }
    private fun initRecyclerView(){
        val recyclerView = binding.recyclerViewPlayers
        recyclerView.layoutManager = LinearLayoutManager(this)
        Log.d("Players", list.toString())
        recyclerView.adapter = PlayersAdapter(list)
    }
}