package com.daviud.spanishlaliga.data.repositories

import com.daviud.spanishlaliga.data.network.TeamsApi

class TeamsRespository (private  val api : TeamsApi) :  SafeApiResquest() {
    suspend fun getTeams() = apiRequest { api.getTeams() }
}