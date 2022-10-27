package com.example.win8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win8.adapters.TeamsAdapter
import com.example.win8.adapters.TermsAdapter
import com.example.win8.databinding.ActivityTeamsBinding
import com.example.win8.model.TeamsStat
import com.example.win8.model.Terminology
import com.example.win8.repository.TeamsRepository
import com.example.win8.service.ApiInterface
import com.example.win8.viewmodel.TeamsViewModel
import com.example.win8.viewmodel.TeamsViewModelFactory

class TeamsActivity : AppCompatActivity() {
    lateinit var binding: ActivityTeamsBinding
    lateinit var teamsViewModel: TeamsViewModel
    var list: ArrayList<TeamsStat> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface = Util.getInstance().create(ApiInterface::class.java)
        val teamsRepository = TeamsRepository(apiInterface)

        teamsViewModel = ViewModelProvider(this,
            TeamsViewModelFactory(teamsRepository)).get(TeamsViewModel::class.java)
        teamsViewModel.teams.observe(this){
            Log.d("Teams", it.toString())
            for(i in it.teamsStats){
                list.add(i)
            }
            initRecyclerView()
        }
    }

    private fun initRecyclerView(){
        val recyclerView = binding.recyclerViewTeams
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TeamsAdapter(list)

    }
}