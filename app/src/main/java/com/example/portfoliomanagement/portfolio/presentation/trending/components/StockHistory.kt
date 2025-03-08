package com.example.portfoliomanagement.portfolio.presentation.trending.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun StockHistory(stocks: List<StockPriceUi>) {
    LazyRow (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(stocks) {stock ->
            StockHistoryItem(stock)
        }
    }
}

@PreviewLightDark
@Composable
private fun StockHistoryPreview() {
    PortfolioManagementTheme {
        StockHistory(priceStocksPreview)
    }
}