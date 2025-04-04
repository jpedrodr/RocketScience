package com.mindera.data.info.di

import com.mindera.data.info.CompanyInfoRepositoryImpl
import com.mindera.domain.info.repository.CompanyInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object InfoDataModule {

    @Provides
    fun provideCompanyInfoRepository(): CompanyInfoRepository {
        return CompanyInfoRepositoryImpl()
    }
}