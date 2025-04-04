package com.mindera.domain.info.repository

interface CompanyInfoRepository {

    suspend fun getCompanyInfo(): String
}