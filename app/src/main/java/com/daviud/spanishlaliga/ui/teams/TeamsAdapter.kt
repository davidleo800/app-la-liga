package com.daviud.spanishlaliga.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daviud.spanishlaliga.R
import com.daviud.spanishlaliga.data.models.TeamsListResponse
import com.daviud.spanishlaliga.databinding.RecyclerviewTeamBinding

class TeamsAdapter(private val teams: TeamsListResponse, private val listener: RecyclerViewClickListener, val itemClick: (Int) -> Unit) : RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> (){


    override fun getItemCount() = teams.teams.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TeamsViewHolder(
            DataBindingUtil.inflate<RecyclerviewTeamBinding>(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_team,
                parent,
                false
            )
        )

    inner class TeamsViewHolder( val recyclerviewTeamBinding: RecyclerviewTeamBinding ) : RecyclerView.ViewHolder( recyclerviewTeamBinding.root )

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.recyclerviewTeamBinding.team = teams.teams[position]
        holder.recyclerviewTeamBinding.root.setOnClickListener {
            listener.onRecyclerViewItemClick(holder.recyclerviewTeamBinding.cardviewTeam, teams.teams[position])
            itemClick(position)
        }
    }

}