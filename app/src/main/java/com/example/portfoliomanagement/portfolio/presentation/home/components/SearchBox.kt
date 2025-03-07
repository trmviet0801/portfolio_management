package com.example.portfoliomanagement.portfolio.presentation.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme

@Composable
fun SearchBox(keyword: MutableState<String>) {
    val containerColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextField(
            value = keyword.value,
            onValueChange = {
                keyword.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .border((0.4).dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(12.dp),
            trailingIcon = {
                Icon(
                    ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = stringResource(R.string.search),
                )
            },
            colors = TextFieldDefaults.colors().copy(
                disabledContainerColor = containerColor,
                unfocusedContainerColor = containerColor,
                focusedContainerColor = containerColor,
                errorContainerColor = containerColor,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(
                    text = stringResource(R.string.search_placeholder),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@PreviewLightDark
@Composable
private fun SearchBoxPreview() {
    PortfolioManagementTheme {
        val keyword = mutableStateOf("")
        SearchBox(keyword)
    }
}