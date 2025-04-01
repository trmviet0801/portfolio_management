package com.example.portfoliomanagement.portfolio.presentation.utils

import com.example.portfoliomanagement.portfolio.domain.User
import com.example.portfoliomanagement.portfolio.presentation.model.Portfolio
import com.example.portfoliomanagement.portfolio.presentation.profile.model.Price
import com.example.portfoliomanagement.portfolio.presentation.model.StockPriceUi
import java.time.Instant

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

val pricesPreview: List<Price> = listOf(
    Price(100.00, Instant.parse("2025-03-01T10:00:00Z")), // Starting at $100
    Price(100.45, Instant.parse("2025-03-01T10:05:00Z")), // +0.45 (slight uptick)
    Price(99.80, Instant.parse("2025-03-01T10:10:00Z")),  // -0.65 (dip)
    Price(100.20, Instant.parse("2025-03-01T10:15:00Z")), // +0.40 (recovery)
    Price(99.50, Instant.parse("2025-03-01T10:20:00Z")),  // -0.70 (volatility)
    Price(98.75, Instant.parse("2025-03-01T10:25:00Z")),  // -0.75 (downtrend starts)
    Price(98.90, Instant.parse("2025-03-01T10:30:00Z")),  // +0.15 (small bounce)
    Price(99.25, Instant.parse("2025-03-01T10:35:00Z")),  // +0.35 (stabilizing)
    Price(100.10, Instant.parse("2025-03-01T10:40:00Z")), // +0.85 (upward move)
    Price(101.30, Instant.parse("2025-03-01T10:45:00Z")), // +1.20 (momentum)
    Price(102.15, Instant.parse("2025-03-01T10:50:00Z")), // +0.85 (continuing up)
    Price(101.80, Instant.parse("2025-03-01T10:55:00Z")), // -0.35 (pullback)
    Price(103.00, Instant.parse("2025-03-01T11:00:00Z")), // +1.20 (breakout)
    Price(102.60, Instant.parse("2025-03-01T11:05:00Z")), // -0.40 (profit-taking)
    Price(103.75, Instant.parse("2025-03-01T11:10:00Z")), // +1.15 (new high)
    Price(104.20, Instant.parse("2025-03-01T11:15:00Z")), // +0.45 (steady climb)
    Price(103.90, Instant.parse("2025-03-01T11:20:00Z")), // -0.30 (slight dip)
    Price(104.50, Instant.parse("2025-03-01T11:25:00Z")), // +0.60 (rebound)
    Price(105.10, Instant.parse("2025-03-01T11:30:00Z")), // +0.60 (uptrend)
    Price(104.85, Instant.parse("2025-03-01T11:35:00Z"))  // -0.25 (end with minor pullback)
)