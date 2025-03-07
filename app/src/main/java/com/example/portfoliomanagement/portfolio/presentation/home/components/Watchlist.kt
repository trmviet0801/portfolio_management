package com.example.portfoliomanagement.portfolio.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import com.example.portfoliomanagement.portfolio.presentation.utils.priceStocksPreview
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun WatchList(stocks: List<StockPriceUi>) {
    Column (
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

        ) {
            Text(
                text = stringResource(R.string.your_watchlist),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.edit_watchlist),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.secondary
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.arrow_right),
                    contentDescription = stringResource(R.string.see_detail),
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(10.dp)
                )
            }
        }
        LazyColumn (
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxHeight(0.7f)
        ) {
            items(stocks) {stock ->
                WatchlistItem(stock)
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun WatchListPreview() {
    PortfolioManagementTheme {
        WatchList(priceStocksPreview)
    }
}