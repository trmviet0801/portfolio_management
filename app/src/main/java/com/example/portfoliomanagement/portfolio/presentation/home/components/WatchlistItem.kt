package com.example.portfoliomanagement.portfolio.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun WatchlistItem(stock: StockPriceUi) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border((0.4).dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp))
            //.padding(8.dp),
                ,
        colors = CardDefaults.cardColors().copy(
            containerColor = containerColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = stock.companyName,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = stock.symbol,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
            Column (
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${stock.currentPrice}",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Row() {
                    if (stock.change > 0) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "+${stock.change} (+${stock.percentChange})",
                                color = MaterialTheme.colorScheme.tertiary,
                                fontSize = 14.sp,
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.up),
                                contentDescription = stringResource(R.string.up),
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    } else {
                        Row(
                           horizontalArrangement = Arrangement.spacedBy(4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${stock.change} (${stock.percentChange})",
                                color = MaterialTheme.colorScheme.error,
                                fontSize = 14.sp,
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.down),
                                contentDescription = stringResource(R.string.up),
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun WatchlistItemPreview() {
    PortfolioManagementTheme {
        WatchlistItem(priceStocksPreview[1])
    }
}