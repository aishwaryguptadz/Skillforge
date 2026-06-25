package com.skillforge.app.data.repository

import com.skillforge.app.data.api.RetrofitClient
import com.skillforge.app.data.model.ApiResponse

object SkillforgeRepository {
    private var cache: ApiResponse? = null
    suspend fun getSkillforgeData(): ApiResponse {
        cache?.let { return it }
        cache = RetrofitClient.api.getSkillforgeData()
        return cache!!
    }
}