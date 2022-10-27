package com.example.win8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.win8.R
import com.example.win8.model.TeamsStat

class TeamsAdapter(val listTeams: List<TeamsStat>) :
    RecyclerView.Adapter<TeamsAdapter.MainHolder>() {
    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewTeam = itemView.findViewById<ImageView>(R.id.team_image)
        val tvName = itemView.findViewById<TextView>(R.id.name_team)
        val tvRank = itemView.findViewById<TextView>(R.id.tv_rank_team)
        val tvGp = itemView.findViewById<TextView>(R.id.tv_gp)
        val tvW = itemView.findViewById<TextView>(R.id.tv_w)
        val tvL = itemView.findViewById<TextView>(R.id.tv_l)
        fun binding(
            image: String,
            name: String,
            rank: String, gp: String,
            w: String,
            l: String
        ) {
            Glide.with(itemView.context)
                .load(image)
                .centerCrop()
                .into(imageViewTeam)
            tvName.text = name
            tvRank.text = rank
            tvGp.text = gp
            tvW.text = w
            tvL.text = l
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teams_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.binding(
            listTeams[position].img,
            listTeams[position].name,
            listTeams[position].rank,
            listTeams[position].gp,
            listTeams[position].w,
            listTeams[position].l
        )
    }

    override fun getItemCount(): Int {
        return listTeams.size
    }
}