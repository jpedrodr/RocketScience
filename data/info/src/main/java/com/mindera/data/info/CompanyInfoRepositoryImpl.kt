package com.mindera.data.info

import com.mindera.data.info.api.InfoService
import com.mindera.data.info.model.CompanyInfoDataModel
import com.mindera.data.info.model.mapper.toDomainModel
import com.mindera.domain.info.model.CompanyInfoDomainModel
import com.mindera.domain.info.repository.CompanyInfoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CompanyInfoRepositoryImpl @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val infoService: InfoService
) : CompanyInfoRepository {

    override suspend fun getCompanyInfo(): CompanyInfoDomainModel = withContext(ioDispatcher) {
        infoService.getCompanyInfo().toDomainModel()
    }
}