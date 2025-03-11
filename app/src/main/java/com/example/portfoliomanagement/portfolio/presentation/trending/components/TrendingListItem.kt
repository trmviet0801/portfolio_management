package com.example.portfoliomanagement.portfolio.presentation.trending.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun TrendingListItem(stock: StockPriceUi) {
    val priceColor: Color =
        if (stock.change > 0) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stock.symbol,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp
            )
            Text(
                text = stock.companyName,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 12.sp
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${stock.currentPrice}",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp
            )
            Text(
                text = "${stock.change} (${stock.percentChange}%)",
                color = priceColor,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun TrendingListItemPreview() {
    PortfolioManagementTheme {
        TrendingListItem(priceStocksPreview[1])
    }
}