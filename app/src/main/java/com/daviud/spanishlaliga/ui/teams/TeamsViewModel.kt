package com.daviud.spanishlaliga.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daviud.spanishlaliga.util.Coroutines
import com.daviud.spanishlaliga.data.models.TeamsListResponse
import com.daviud.spanishlaliga.data.repositories.TeamsRespository
import kotlinx.coroutines.Job
import java.text.FieldPosition

class  TeamsViewModel( private val repository : TeamsRespository) : ViewModel() {

    private val _teams = MutableLiveData<TeamsListResponse>()
    private lateinit var job: Job
    val isLoading = MutableLiveData<Boolean>()

    private var _position = MutableLiveData(10)
    val position : LiveData<Int> = _position

    val teams : LiveData<TeamsListResponse>

        get() = _teams

    fun getTeams() {
        job = Coroutines.ioThenMain(
            {
                repository.getTeams()
            },
            {
                _teams.value = it
            }
        )
    }

    fun savePosition(newPosition: Int){
        _position.value = newPosition
    }

    fun getTeamsbyId(id: Int) {
        job = Coroutines.ioThenMain(
            {
                repository.getTeams()
            },
            {
                _teams.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }

}