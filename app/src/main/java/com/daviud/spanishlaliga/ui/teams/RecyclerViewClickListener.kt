package com.daviud.spanishlaliga.ui.teams

import android.view.View
import com.daviud.spanishlaliga.data.models.Team
import com.daviud.spanishlaliga.data.models.TeamsListResponse
import kotlin.reflect.KFunction1

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, team: Team)
}