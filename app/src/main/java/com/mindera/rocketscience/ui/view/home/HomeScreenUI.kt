package com.mindera.rocketscience.ui.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mindera.rocketscience.R
import com.mindera.rocketscience.model.CompanyInfoUiModel
import com.mindera.rocketscience.ui.theme.RocketScienceTheme
import com.mindera.rocketscience.ui.theme.black
import com.mindera.rocketscience.ui.theme.white

@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.white)
    ) {
        HeaderUI(companyName = state.companyInfo?.companyName, onFilterClick = {println("joaorosa | onClick")})

        SectionUI(label = stringResource(R.string.company))

        state.companyInfo?.let {
            val description = getCompanyInfoDescription(it)
            Text(
                text = description,
                color = MaterialTheme.colorScheme.black,
                modifier = Modifier.padding(8.dp)
            )
        }

        SectionUI(label = stringResource(R.string.launches))
    }
}

@Composable
private fun HeaderUI(
    companyName: String?,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(64.dp)
    ) {
        companyName?.let {
            Text(
                text = it,
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Icon(
            imageVector = Icons.Filled.FilterAlt,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(48.dp)
                .padding(end = 8.dp)
                .clickable { onFilterClick() }
                .border(2.dp, color = MaterialTheme.colorScheme.black),
            contentDescription = null
        )
    }
}

@Composable
private fun SectionUI(label: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.black)
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.white,
            fontSize = 20.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
private fun getCompanyInfoDescription(companyInfo: CompanyInfoUiModel): String {
    return with(companyInfo) {
        stringResource(
            R.string.company_info,
            companyName,
            founderName,
            foundedYear,
            employees,
            launchSites,
            valuation
        )
    }
}

@Composable
@Preview
fun HomeScreenUIPreview() {
    RocketScienceTheme {
        HomeScreenUI()
    }
}