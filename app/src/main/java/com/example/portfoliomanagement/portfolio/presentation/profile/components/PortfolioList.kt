package com.example.portfoliomanagement.portfolio.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.portfoliomanagement.portfolio.presentation.home.components.WatchlistItem
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun PortfolioList(stocks: List<StockPriceUi>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(stocks) {stock ->
            WatchlistItem(stock)
        }
    }
}

@PreviewLightDark
@Composable
private fun PortfolioListPreview() {
    PortfolioManagementTheme {
        PortfolioList(priceStocksPreview)
    }
}