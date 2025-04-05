package com.mindera.data.info.di

import com.mindera.data.info.CompanyInfoRepositoryImpl
import com.mindera.data.info.api.InfoService
import com.mindera.domain.info.repository.CompanyInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InfoDataModule {

    @Provides
    @Singleton
    fun provideInfoService(retrofit: Retrofit): InfoService =
        retrofit.create(InfoService::class.java)

    @Provides
    fun provideCompanyInfoRepository(
        infoService: InfoService
    ): CompanyInfoRepository = CompanyInfoRepositoryImpl(infoService)
}