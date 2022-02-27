package com.daviud.spanishlaliga.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daviud.spanishlaliga.R
import com.daviud.spanishlaliga.data.models.Team
import com.daviud.spanishlaliga.data.network.TeamsApi
import com.daviud.spanishlaliga.data.repositories.TeamsRespository
import kotlinx.android.synthetic.main.teams_fragment.*
import androidx.navigation.findNavController


class TeamsFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var factory: TeamsViewModelFactory
    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teams_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = TeamsApi()
        val repository = TeamsRespository(api)
        factory = TeamsViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), factory)[TeamsViewModel::class.java]
        viewModel.getTeams()
        viewModel.teams.observe(viewLifecycleOwner, Observer { teams ->
            recyclerview_teams.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = TeamsAdapter(teams, this) {
                    val it1 = it
                    viewModel.savePosition(it1)
                }
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, team: Team) {
        when(view.id){
            R.id.cardview_team -> {
                view.findNavController().navigate(R.id.navigate_details)

            }
        }
    }


}