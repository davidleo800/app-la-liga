package com.daviud.spanishlaliga.ui.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daviud.spanishlaliga.data.repositories.TeamsRespository

class TeamsViewModelFactory (private val repository: TeamsRespository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamsViewModel(repository) as T
    }

}