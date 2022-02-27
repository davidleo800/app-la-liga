package com.daviud.spanishlaliga.ui.teams

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.daviud.spanishlaliga.R
import com.daviud.spanishlaliga.data.models.Team
import com.daviud.spanishlaliga.data.models.TeamsListResponse
import com.daviud.spanishlaliga.data.network.TeamsApi
import com.daviud.spanishlaliga.data.repositories.TeamsRespository
import kotlinx.android.synthetic.main.teams_fragment.*
import kotlin.reflect.KFunction1

class DetailTeamFragment : Fragment(), RecyclerViewClickListener {

    companion object {
        fun newInstance() = DetailTeamFragment()
    }

    private lateinit var factory: TeamsViewModelFactory
    private lateinit var viewModel: TeamsViewModel
    var post = 0
    // private lateinit var viewModel: DetailTeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_team_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // viewModel = ViewModelProvider(this).get(DetailTeamViewModel::class.java)
        // TODO: Use the ViewModel

        val api = TeamsApi()
        val repository = TeamsRespository(api)
        factory = TeamsViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), factory)[TeamsViewModel::class.java]
        viewModel.getTeams()

        viewModel.position.observe(viewLifecycleOwner, Observer { position ->

            post = position
            Toast.makeText(requireContext(), "Position $position", Toast.LENGTH_LONG).show()

        })

        viewModel.teams.observe(viewLifecycleOwner, Observer { teams ->

            Toast.makeText(requireContext(), "Position ${teams.teams[post]}", Toast.LENGTH_LONG).show()

        })



    }

    override fun onRecyclerViewItemClick(view: View, team: Team) {
        TODO("Not yet implemented")
    }


}