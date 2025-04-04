package com.mindera.data.info.di

import com.mindera.data.info.CompanyInfoRepositoryImpl
import com.mindera.domain.info.repository.CompanyInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InfoDataModule {

    @Provides
    fun provideBaseUrl(): String = "https://api.spacexdata.com/v3/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideMyApiService(retrofit: Retrofit): MyApiService {
        return retrofit.create(MyApiService::class.java)
    }

    @Provides
    fun provideCompanyInfoRepository(): CompanyInfoRepository {
        return CompanyInfoRepositoryImpl()
    }
}