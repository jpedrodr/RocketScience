package com.mindera.domain.info.repository

import com.mindera.domain.info.model.CompanyInfoDomainModel

interface CompanyInfoRepository {

    suspend fun getCompanyInfo(): CompanyInfoDomainModel
}