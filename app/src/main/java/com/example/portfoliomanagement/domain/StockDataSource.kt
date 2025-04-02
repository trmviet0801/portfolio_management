package com.example.portfoliomanagement.domain

import com.example.portfoliomanagement.portfolio.domain.Stock

interface StockDataSource{
    suspend fun getStock(symbol: String): Result<Stock, NetworkError>
}