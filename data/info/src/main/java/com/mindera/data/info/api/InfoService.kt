package com.mindera.data.info.api

import com.mindera.data.info.model.CompanyInfoDataModel

interface InfoService {

    @GET("info")
    suspend fun getCompanyInfo(): CompanyInfoDataModel
}