package com.mindera.data.info

import com.mindera.domain.info.repository.CompanyInfoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CompanyInfoRepositoryImpl @Inject constructor(
//    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : CompanyInfoRepository {

    override suspend fun getCompanyInfo(): String = withContext(Dispatchers.IO) {
        return@withContext "SpaceX"
    }
}