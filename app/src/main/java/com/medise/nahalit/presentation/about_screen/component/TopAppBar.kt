package com.medise.nahalit.presentation.about_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.medise.nahalit.presentation.ui.theme.pale_dark

@Composable
fun AboutTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    color: Color,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (titleString, arrowBack) = createRefs()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(arrowBack) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                contentAlignment = Alignment.CenterStart
            ) {
                IconButton(
                    onClick = { onBackClick() },
                ) {
                    Icon(
                        modifier = Modifier.size(32.dp, 32.dp),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = Icons.Default.ArrowBack.name,
                        tint = Color.Black
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(titleString) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    color = color,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 33.sp,
                )
            }
        }
    }
}