package com.example.basecode.di

import com.example.basecode.network.ApiServices
import com.example.basecode.network.RemoteClientApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApi(remoteClientApi: RemoteClientApi): ApiServices {
        return remoteClientApi.buildApi(ApiServices::class.java)
    }
}
