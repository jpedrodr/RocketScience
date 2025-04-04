package com.mindera.rocketscience.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mindera.rocketscience.ui.theme.RocketScienceTheme
import com.mindera.rocketscience.ui.view.home.HomeScreenUI

@Composable
fun RocketScienceContent() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HomeScreenUI(modifier = Modifier.padding(paddingValues = innerPadding))
    }
}

@Preview
@Composable
fun RocketScienceContentPreview() {
    RocketScienceTheme {
        RocketScienceContent()
    }
}
