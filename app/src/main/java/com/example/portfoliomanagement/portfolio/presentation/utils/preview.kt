package com.example.portfoliomanagement.portfolio.presentation.utils

import com.example.portfoliomanagement.portfolio.domain.User
import com.example.portfoliomanagement.portfolio.presentation.model.Portfolio
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi

val previewUser = User(username = "Fery Pratama")

val priceStocksPreview = listOf(
    StockPriceUi(
        companyName = "Boeing Co",
        symbol = "Boe",
        currentPrice = 139.3550,
        change = -0.8,
        percentChange = -0.37,
        highPriceOfTheDay = 123.123,
        openPriceOfTheDay = 123.123,
        previousClosePrice = 123.123
    ),
    StockPriceUi(
        companyName = "Boeing Co",
        symbol = "Boe",
        currentPrice = 139.3550,
        change = 0.8,
        percentChange = 0.37,
        highPriceOfTheDay = 123.123,
        openPriceOfTheDay = 123.123,
        previousClosePrice = 123.123
    ),
    StockPriceUi(
        companyName = "Boeing Co",
        symbol = "Boe",
        currentPrice = 139.3550,
        change = 0.8,
        percentChange = 0.37,
        highPriceOfTheDay = 123.123,
        openPriceOfTheDay = 123.123,
        previousClosePrice = 123.123
    ),
    StockPriceUi(
        companyName = "Boeing Co",
        symbol = "Boe",
        currentPrice = 139.3550,
        change = -0.8,
        percentChange = -0.37,
        highPriceOfTheDay = 123.123,
        openPriceOfTheDay = 123.123,
        previousClosePrice = 123.123
    ),
    StockPriceUi(
        companyName = "Boeing Co",
        symbol = "Boe",
        currentPrice = 139.3550,
        change = 0.8,
        percentChange = 0.37,
        highPriceOfTheDay = 123.123,
        openPriceOfTheDay = 123.123,
        previousClosePrice = 123.123
    )
)

val portfolioPreview: Portfolio = Portfolio(2125.0, 206.92, 10.6)
