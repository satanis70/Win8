package com.example.win8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.win8.R
import com.example.win8.model.Rating

class PlayersAdapter(
    val listPlayers: List<Rating>
) : RecyclerView.Adapter<PlayersAdapter.MainHolder>() {

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.img_player_image)
        val tvName = itemView.findViewById<TextView>(R.id.tv_player_name)
        val tvTeamName = itemView.findViewById<TextView>(R.id.tv_team_name)
        val tvRank = itemView.findViewById<TextView>(R.id.tv_rank_player)
        val tvNhlRating = itemView.findViewById<TextView>(R.id.tv_nhl_rating)
        val tvStyle = itemView.findViewById<TextView>(R.id.tv_player_style)
        val tvAge = itemView.findViewById<TextView>(R.id.tv_age)

        fun binding(
            image: String,
            name: String,
            teamName: String,
            rank: String,
            nhlRating: String,
            style: String,
            age: String
        ){
            Glide.with(itemView.context)
                .load(image)
                .circleCrop()
                .into(imageView)
            tvName.text = name
            tvTeamName.text = "Team: $teamName"
            tvRank.text = "Rank: $rank"
            tvNhlRating.text = "NHL rating: $nhlRating"
            tvStyle.text = "Player Style: $style"
            tvAge.text = "Age: $age"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.players_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.binding(
            listPlayers[position].img,
            listPlayers[position].name,
            listPlayers[position].team,
            listPlayers[position].rank,
            listPlayers[position].nHLRating,
            listPlayers[position].playerstyle,
            listPlayers[position].age
        )
    }

    override fun getItemCount(): Int {
        return listPlayers.size
    }
}