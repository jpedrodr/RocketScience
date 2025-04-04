package com.mindera.rocketscience.di

import com.mindera.data.info.CompanyInfoRepositoryImpl
import com.mindera.domain.info.repository.CompanyInfoRepository
import com.mindera.domain.info.usecase.GetCompanyInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    fun provideCompanyInfoRepository(): CompanyInfoRepository {
//        return CompanyInfoRepositoryImpl() // The actual implementation of the repository
//    }

    @Provides
    fun provideGetCompanyInfoUseCase(repository: CompanyInfoRepository): GetCompanyInfoUseCase {
        return GetCompanyInfoUseCase(repository)
    }
}