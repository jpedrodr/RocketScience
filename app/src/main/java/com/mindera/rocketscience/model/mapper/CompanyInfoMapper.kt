package com.mindera.rocketscience.model.mapper

import com.mindera.domain.info.model.CompanyInfoDomainModel
import com.mindera.rocketscience.model.CompanyInfoUiModel

fun CompanyInfoDomainModel.toUiModel() = CompanyInfoUiModel(
    companyName = companyName,
    founderName = founderName,
    foundedYear = foundedYear,
    employees = employees,
    launchSites = launchSites,
    valuation = valuation
)