package com.medise.nahalit.presentation.profile_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.R
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white

@Composable
fun ProfileTopAppBar(
    title:String,
    onNavigateIconClick: () -> Unit,

) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.SemiBold
                )

                IconButton(
                    onClick = onNavigateIconClick,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Image(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(R.string.Menu),
                        colorFilter = ColorFilter.tint(ghost_white)
                    )
                }
            }
        },
        backgroundColor = colorPrimary,
        elevation = 0.dp
    )
}