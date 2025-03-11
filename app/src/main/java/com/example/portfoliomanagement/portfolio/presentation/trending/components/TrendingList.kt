package com.example.portfoliomanagement.portfolio.presentation.trending.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun TrendingList(stocks: List<StockPriceUi>) {
    TrendingTopBar()
    Column (
        modifier = Modifier
            .padding(8.dp)
            .padding(vertical = 16.dp)
            .fillMaxWidth()
    ) {
        stocks.forEach {
            TrendingListItem(it)
        }
        SeeMoreButton()
    }
}

@PreviewLightDark
@Composable
private fun TrendingListPreview() {
    PortfolioManagementTheme {
        TrendingList(priceStocksPreview)
    }
}