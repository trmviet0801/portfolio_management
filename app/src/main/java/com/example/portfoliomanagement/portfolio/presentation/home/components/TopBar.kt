package com.example.portfoliomanagement.portfolio.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portfoliomanagement.R
import com.example.portfoliomanagement.portfolio.domain.User
import com.example.portfoliomanagement.ui.theme.Grey
import com.example.portfoliomanagement.ui.theme.PortfolioManagementTheme
import com.example.portfoliomanagement.ui.theme.White

@Composable
fun TopBar(user: User) {
    Row (
        modifier = Modifier
            .padding(8.dp)
            .height(50.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row() {
            Card (
                shape = RoundedCornerShape(26.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.avatar),
                    contentDescription = stringResource(R.string.avatar),
                    Modifier
                        .fillMaxHeight()
                )
            }

            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.hello),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Thin,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = user.username,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.bell),
            contentDescription = stringResource(R.string.bell),
            Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

private val previewUser = User(username = "Fery Pratama")

@PreviewLightDark
@Composable
private fun TopBarPreview() {
    PortfolioManagementTheme {
        TopBar(previewUser)
    }
}