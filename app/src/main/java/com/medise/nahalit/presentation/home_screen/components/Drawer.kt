package com.medise.nahalit.presentation.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.presentation.ui.theme.colorPrimary

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.255f)
            .background(colorPrimary)
    ) {
        Column {
        }
    }
}

@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable {
                        onItemClick(item)
                    }
            ) {
                Icon(imageVector = item.icon, contentDescription = item.title)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title, modifier = Modifier.weight(1f), fontSize = 20.sp)
            }
            if (item != items[items.lastIndex]) {
                Divider()
            }
        }
    }
}

data class MenuItem(
    val id: Int,
    val title: String,
    val icon: ImageVector
)