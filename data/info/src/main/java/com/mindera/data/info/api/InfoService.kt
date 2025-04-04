package com.mindera.data.info.api

import com.mindera.data.info.model.CompanyInfoDataModel
import retrofit2.http.GET

interface InfoService {

    @GET("info")
    suspend fun getCompanyInfo(): CompanyInfoDataModel
}