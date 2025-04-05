package com.mindera.rocketscience.ui.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindera.domain.info.usecase.GetCompanyInfoUseCase
import com.mindera.rocketscience.model.CompanyInfoUiModel
import com.mindera.rocketscience.model.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCompanyInfoUseCase: GetCompanyInfoUseCase
) : ViewModel() {

    init {
        loadCompanyInfo()
    }

    private val _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    fun loadCompanyInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            val companyInfo = getCompanyInfoUseCase()
            _uiState.update {
                println("joaorosa | companyInfo=$companyInfo")
                it.copy(companyInfo = companyInfo.toUiModel())
            }
        }
    }
}

data class HomeState(
    val companyInfo: CompanyInfoUiModel? = null
)