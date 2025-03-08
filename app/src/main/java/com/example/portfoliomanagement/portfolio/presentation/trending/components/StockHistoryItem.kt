package com.example.portfoliomanagement.portfolio.presentation.trending.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun StockHistoryItem(stock: StockPriceUi) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        val icon: Int = if (stock.change > 0) R.drawable.up else R.drawable.down
        val contentColor =
            if (stock.change > 0) MaterialTheme.colorScheme.tertiary
            else MaterialTheme.colorScheme.error
        Row(
            horizontalArrangement = Arrangement.spacedBy(3.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = stringResource(R.string.icon),
                tint = contentColor,
                modifier = Modifier.size(24.dp)
            )
            Column (
                verticalArrangement = Arrangement.spacedBy((-8).dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stock.symbol,
                    fontSize = 14.sp,
                    color = contentColor
                )
                Text(
                    text = "${stock.currentPrice}",
                    fontSize = 14.sp,
                    color = contentColor
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun StockHistoryItemPreview() {
    PortfolioManagementTheme {
        StockHistoryItem(priceStocksPreview[0])
    }
}