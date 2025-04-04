package com.mindera.domain.info.usecase

import com.mindera.domain.info.model.CompanyInfoDomainModel
import com.mindera.domain.info.repository.CompanyInfoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCompanyInfoUseCase(
    private val repository: CompanyInfoRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(): CompanyInfoDomainModel = withContext(ioDispatcher) {
        repository.getCompanyInfo()
    }
}

