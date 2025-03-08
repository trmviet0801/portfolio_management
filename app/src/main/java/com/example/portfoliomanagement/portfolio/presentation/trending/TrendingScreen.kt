package com.example.portfoliomanagement.portfolio.presentation.trending

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.portfoliomanagement.portfolio.presentation.trending.components.TopBar
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun TrendingScreen() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TopBar()
    }
}

@PreviewLightDark
@Composable
private fun TrendingScreenPreview() {
    PortfolioManagementTheme {
        TrendingScreen()
    }
}