package com.skillforge.app.data.repository

import com.skillforge.app.data.api.RetrofitClient
import com.skillforge.app.data.model.ApiResponse

class SkillforgeRepository {
    suspend fun getSkillforgeData(): ApiResponse {
        return RetrofitClient.api.getSkillforgeData()
    }
}