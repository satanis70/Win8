package com.example.win8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win8.R
import com.example.win8.model.Terminology

class TermsAdapter(val termsList: List<Terminology>): RecyclerView.Adapter<TermsAdapter.MainHolder>(){

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTitle = itemView.findViewById<TextView>(R.id.title_item_terms)
        val tvDescription = itemView.findViewById<TextView>(R.id.description_terms)
        fun binding(title: String, description: String){
            tvTitle.text = title
            tvDescription.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.terms_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.binding(termsList[position].name, termsList[position].description)
    }

    override fun getItemCount(): Int {
        return termsList.size
    }
}