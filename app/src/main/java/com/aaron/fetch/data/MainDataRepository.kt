package com.aaron.fetch.data

import com.aaron.fetch.data.remote.MainDataManager
import com.aaron.fetch.data.remote.service.FetchHiringAPIs
import retrofit2.Retrofit
import retrofit2.create

class MainDataRepository(
    private var retrofit: Retrofit,
) : DataRepository() {
    override fun getNetworkDataManager(): MainDataManager =
        MainDataManager(
            retrofit = retrofit
        )

    override fun getApplicationApiService(): FetchHiringAPIs =
        getNetworkDataManager()
            .getRetrofit()
            .create<FetchHiringAPIs>()

}