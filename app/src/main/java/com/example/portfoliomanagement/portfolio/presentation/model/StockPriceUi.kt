package com.example.portfoliomanagement.portfolio.presentation.model

data class StockPriceUi(
    val companyName: String,
    val symbol: String,
    val currentPrice: Double,
    val change: Double,
    val percentChange: Double,
    val highPriceOfTheDay: Double,
    val openPriceOfTheDay: Double,
    val previousClosePrice: Double
)
