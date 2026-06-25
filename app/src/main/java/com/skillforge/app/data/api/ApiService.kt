package com.skillforge.app.data.api

import com.skillforge.app.data.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("android-assesment/notes/refs/heads/main/data.json")
    suspend fun getSkillforgeData(): ApiResponse
}