package com.example.portfoliomanagement.portfolio.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun TopMenu() {
    val icons = listOf(
        R.drawable.plus,
        R.drawable.cash,
        R.drawable.chart,
        R.drawable.ipo
    )
    val titles = listOf(
        R.string.add_money,
        R.string.currencies,
        R.string.indices,
        R.string.ipo
    )
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        icons.forEachIndexed { index, i ->
            TopMenuItem(i, stringResource(titles[index]))
        }
    }
}

@PreviewLightDark
@Composable
private fun TopMenuPreview() {
    PortfolioManagementTheme {
        TopMenu()
    }
}