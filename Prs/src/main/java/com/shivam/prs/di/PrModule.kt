package com.shivam.prs.di

import com.shivam.prs.api.PrApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object PrModule {

    @Provides
    fun providePrApi(retrofit: Retrofit): PrApi {
        return retrofit.create(PrApi::class.java)
    }

}