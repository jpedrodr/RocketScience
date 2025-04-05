package com.mindera.data.info.model.mapper

import com.mindera.data.info.model.CompanyInfoDataModel
import com.mindera.domain.info.model.CompanyInfoDomainModel

fun CompanyInfoDataModel.toDomainModel() = CompanyInfoDomainModel(
    companyName = companyName,
    founderName = founderName,
    foundedYear = foundedYear,
    employees = employees,
    launchSites = launchSites,
    valuation = valuation
)