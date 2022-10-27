package com.example.win8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win8.adapters.TermsAdapter
import com.example.win8.databinding.ActivityTermsBinding
import com.example.win8.model.Terminology
import com.example.win8.repository.TermsRepository
import com.example.win8.service.ApiInterface
import com.example.win8.viewmodel.TermsViewModel
import com.example.win8.viewmodel.TermsViewModelFactory

class TermsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermsBinding
    private lateinit var termsViewModel: TermsViewModel
    var list: ArrayList<Terminology> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface = Util.getInstance().create(ApiInterface::class.java)
        val termsRepository = TermsRepository(apiInterface)

        termsViewModel = ViewModelProvider(this,
            TermsViewModelFactory(termsRepository)).get(TermsViewModel::class.java)
        termsViewModel.terms.observe(this) {
            Log.d("Terms", it.toString())
            for (i in it.terminology){
                list.add(i)
            }
            initRecyclerView()
        }

    }

    private fun initRecyclerView(){
        val recyclerView = binding.recyclerViewTerms
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TermsAdapter(list)

    }
}