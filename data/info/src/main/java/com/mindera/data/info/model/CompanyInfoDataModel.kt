package com.mindera.data.info.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyInfoDataModel(
    @SerialName("name") val companyName: String,
    @SerialName("founder") val founderName: String,
    @SerialName("founded") val foundedYear: Int,
    @SerialName("launch_sites") val launchSites: Int,
    @SerialName("valuation") val valuation: Long
)