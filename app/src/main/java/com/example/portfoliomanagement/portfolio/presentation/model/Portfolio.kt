package com.example.portfoliomanagement.portfolio.presentation.model

import android.annotation.SuppressLint

data class Portfolio(
    val value: Double,
    val change: Double,
    val percentageChange: Double
)

@SuppressLint("DefaultLocale")
fun Portfolio.format(value: Double): String {
    return String.format("%.3f", value)
}

@SuppressLint("DefaultLocale")
fun Double.format(): String {
    return String.format("%.3f", this)
}