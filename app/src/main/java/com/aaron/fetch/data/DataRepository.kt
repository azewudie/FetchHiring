package com.aaron.fetch.data

import com.aaron.fetch.data.remote.MainDataManager
import com.aaron.fetch.data.remote.service.FetchHiringAPIs

abstract class DataRepository {
    abstract fun getNetworkDataManager(): MainDataManager
    abstract fun getApplicationApiService(): FetchHiringAPIs
}