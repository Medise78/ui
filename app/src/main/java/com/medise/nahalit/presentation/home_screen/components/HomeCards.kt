package com.medise.nahalit.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.medise.nahalit.R
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white

@Composable
fun ProductCard(
    image: String,
    title: String,
    description: String,
    price: String,
    onCardClick: () -> Unit,
    onBuyClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(310.dp)
            .fillMaxWidth(0.5f)
            .padding(15.dp)
            .border(width = 1.dp, color = Color.Black.copy(0.3f), shape = RoundedCornerShape(20.dp))
            .clickable(onClick = onCardClick),
        elevation = 5.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = ghost_white,
    ) {
        ConstraintLayout {
            val (imageConst, titleConst, descriptionConst, priceConst, btnLike, btnBuy) = createRefs()
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(110.dp)
                    .fillMaxWidth()
                    .constrainAs(imageConst) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(titleConst.top)
                    }
            ) {
                AsyncImage(
                    model = image,
                    contentDescription = R.drawable.img.toString(),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .constrainAs(btnLike) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = stringResource(R.string.favorite)
                    )
                }
            }
            Box(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .constrainAs(titleConst) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        bottom.linkTo(descriptionConst.top)
                    }
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    softWrap = true,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                )
            }
            Box(
                modifier = Modifier
                    .padding(top = 5.dp, start = 10.dp, end = 10.dp)
                    .constrainAs(descriptionConst) {
                        top.linkTo(titleConst.bottom)
                        start.linkTo(parent.start)
                    }) {
                Text(
                    text = description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = true,
                    textAlign = TextAlign.Start
                )
            }
            Box(
                modifier = Modifier
                    .padding(top = 0.dp, end = 3.dp, start = 15.dp, bottom = 8.dp)
                    .constrainAs(priceConst) {
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(btnBuy.start)
                    }
            ) {
                Text(
                    text = "${price}﷼ ",
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.mitra)),
                        fontSize = 18.sp
                    )
                )
            }
            Box(
                modifier = Modifier
                    .constrainAs(btnBuy) {
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
            ) {
                CustomButton(onBuyClick)
            }
        }
    }
}