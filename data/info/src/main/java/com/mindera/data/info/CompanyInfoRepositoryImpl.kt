package com.mindera.data.info

import com.mindera.data.info.model.CompanyInfoDataModel
import com.mindera.data.info.model.mapper.toDomainModel
import com.mindera.domain.info.model.CompanyInfoDomainModel
import com.mindera.domain.info.repository.CompanyInfoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CompanyInfoRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CompanyInfoRepository {

    override suspend fun getCompanyInfo(): CompanyInfoDomainModel = withContext(ioDispatcher) {
        CompanyInfoDataModel(
            companyName = "SpaceX",
            founderName = "Elon Musk",
            foundedYear = 2002,
            launchSites = 3,
            valuation = 15000000000
        ).toDomainModel()
    }
}