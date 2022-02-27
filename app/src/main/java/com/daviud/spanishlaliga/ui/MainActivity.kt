package com.daviud.spanishlaliga.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.daviud.spanishlaliga.R
import com.daviud.spanishlaliga.data.models.Team
import com.daviud.spanishlaliga.data.network.TeamsApi
import com.daviud.spanishlaliga.data.repositories.TeamsRespository
import com.daviud.spanishlaliga.ui.teams.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.teams_fragment.*

class MainActivity : AppCompatActivity() {

    //private lateinit var factory: TeamsViewModelFactory
    //private lateinit var viewModel: TeamsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val repository = TeamsRespository(TeamsApi())

        GlobalScope.launch(Dispatchers.Main) {
            val teams = repository.getTeams()
            Toast.makeText(this@MainActivity, teams.toString(), Toast.LENGTH_LONG).show()
        }



        val api = TeamsApi()
        val repository = TeamsRespository(api)
        factory = TeamsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[TeamsViewModel::class.java]
        viewModel.getTeams()


        viewModel.teams.observe(this, Observer { teams ->
            recyclerview_teamsActivity.also {
                it.layoutManager = LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter = TeamsAdapter(teams, this)
            }
        })
        */
    }
    /*
    override fun onRecyclerViewItemClick(view: View, team: Team) {
        when(view.id){
            R.id.cardview_team -> {

                /*
                Toast.makeText(this, "texto $team", Toast.LENGTH_LONG).show()
                val bottomSheetFragment = BottomSheetDialogFragment()
                bottomSheetFragment.show(supportFragmentManager, "BottonSheetDialog")
                */

                val newFragment = DetailTeamFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragmentContainerView, newFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }*/

}