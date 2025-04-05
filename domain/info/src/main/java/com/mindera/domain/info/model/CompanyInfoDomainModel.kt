package com.mindera.domain.info.model

data class CompanyInfoDomainModel(
    val companyName: String,
    val founderName: String,
    val foundedYear: Int,
    val employees: Int,
    val launchSites: Int,
    val valuation: Long
)