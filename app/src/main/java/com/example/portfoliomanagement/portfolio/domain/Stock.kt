package com.example.portfoliomanagement.portfolio.domain

import kotlinx.serialization.Serializable

@Serializable
data class Stock(
    val name: String,
    val symbol: String,
    val marketCap: Double,
    val description: String,
    val price: Double,
    val change: Double,
    val percentChange: Double,
    val volume: Double,
    val pe: Double,
)
