package com.medise.nahalit.presentation.detail_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.presentation.ui.theme.pale_dark

@Composable
fun TopBarWithBack(
    title: String,
    like: Boolean = false,
    onBackClick: () -> Unit,
    onBtnLike: (Boolean) -> Unit
) {
    var likeProduct by remember {
        mutableStateOf(like)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick() }) {
            Icon(
                modifier = Modifier
                    .padding(start = 30.dp),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = Icons.Default.ArrowBack.name,
                tint = Color.Black
            )
        }

        Text(
            text = title,
            color = pale_dark,
            modifier = Modifier.padding(start = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 33.sp,
        )

        Card(
            modifier = Modifier
                .padding(end = 20.dp)
                .width(50.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            IconButton(onClick = {
                likeProduct = !likeProduct
                onBtnLike(likeProduct)
            }) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = Icons.Outlined.Favorite.name,
                    tint = if (likeProduct) Color.Red else Color.Black
                )
            }
        }
    }
}