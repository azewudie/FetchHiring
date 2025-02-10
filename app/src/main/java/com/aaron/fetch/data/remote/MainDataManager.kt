package com.aaron.fetch.data.remote

import retrofit2.Retrofit
class MainDataManager(
    private var retrofit: Retrofit,
) {
    fun getRetrofit(): Retrofit = retrofit
}