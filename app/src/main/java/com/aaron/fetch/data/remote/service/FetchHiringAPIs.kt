package com.aaron.fetch.data.remote.service

import com.aaron.fetch.data.remote.ApiEndPoints
import com.aaron.fetch.data.remote.MainResponse
import com.aaron.fetch.data.remote.models.responses.ResponseError
import com.aaron.fetch.data.remote.models.responses.HiringResponse
import retrofit2.http.GET

interface FetchHiringAPIs {
    @GET(ApiEndPoints.HIRING_JSON)
    suspend fun getFetchHiring(): MainResponse<HiringResponse, ResponseError>
}