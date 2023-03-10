package com.medise.nahalit.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.medise.nahalit.R

@Composable
fun SocialMediaIcons(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row {

            Image(
                bitmap = ImageBitmap.imageResource(id = R.mipmap.ic_instagram),
                contentDescription = "instagram",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.twitter),
                contentDescription = "twitter",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.github),
                contentDescription = "github",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.telegram),
                contentDescription = "telegram",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.linkedin),
                contentDescription = "linkedin",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.youtube),
                contentDescription = "youtube",
                modifier = Modifier.size(40.dp)
            )
        }
    }
}
