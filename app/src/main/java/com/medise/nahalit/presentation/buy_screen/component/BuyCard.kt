package com.medise.nahalit.presentation.buy_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.R

@Composable
fun ItemBuyCard(
    painter: Int,
    title: String,
    price: String,
    size: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(horizontal = 10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(
            topStart = 10.dp,
            topEnd = 10.dp,
            bottomStart = 10.dp,
            bottomEnd = 10.dp
        )
    ) {
        Row {
            Box(modifier = Modifier.padding(5.dp)) {
                Surface(
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = painter),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(150.dp)
                            .width(100.dp)
                    )
                }
            }
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(0.dp),
                        modifier = Modifier.padding(vertical = 10.dp)
                    ) {
                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Text(
                                text = title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(
                                text = "$price﷼",
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.mitra)),
                                fontSize = 18.sp
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                                    .padding(end = 27.dp, top = 8.dp),
                                contentAlignment = Alignment.TopEnd
                            ) {
                                Text(
                                    text = size,
                                    style = MaterialTheme.typography.h5,
                                    color = Color.Black.copy(0.3f),
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.mitra))
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1f)
                                    .padding(
                                        end = 20.dp,
                                        bottom = 8.dp
                                    ),
                                contentAlignment = Alignment.BottomEnd
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "delete",
                                    tint = Color.Red.copy(0.5f),
                                    modifier = Modifier.size(23.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}