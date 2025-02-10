package com.aaron.fetch.di

import com.aaron.fetch.BuildConfig
import com.aaron.fetch.data.DataRepository
import com.aaron.fetch.data.MainDataRepository
import com.aaron.fetch.data.remote.MainResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideBasicOkHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient
            .Builder()

        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofitLevel(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(MainResponseAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDataRepository(
        retrofit: Retrofit,
    ): DataRepository =
        MainDataRepository(
            retrofit,
        )


}