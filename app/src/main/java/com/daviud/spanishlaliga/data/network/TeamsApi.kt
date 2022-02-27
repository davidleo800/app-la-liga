package com.daviud.spanishlaliga.data.network

import com.daviud.spanishlaliga.data.models.TeamsListResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TeamsApi {

    @GET("search_all_teams.php?l=Spanish%20La%20Liga")
    suspend fun getTeams() : Response<TeamsListResponse>

    companion object {
        operator fun invoke() : TeamsApi {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.thesportsdb.com/api/v1/json/2/")
                .build()
                .create(TeamsApi::class.java)
        }
    }
}
