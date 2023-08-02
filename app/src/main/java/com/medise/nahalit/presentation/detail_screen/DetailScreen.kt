package com.medise.nahalit.presentation.detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.medise.nahalit.R
import com.medise.nahalit.domain.model.product.ProductItem
import com.medise.nahalit.presentation.detail_screen.component.TopBarWithBack
import com.medise.nahalit.presentation.ui.theme.*

@Composable
fun DetailScreen(
    navController: NavController
) {

    val detailsScreenViewModel: DetailsScreenViewModel by hiltViewModel()

    var likeProduct by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopBarWithBack(
                title = "محصول", onBackClick = {
                    navController.navigateUp()
                }
            ) {
                likeProduct = !likeProduct
            }
        }
    ) {
        it.calculateBottomPadding()
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 20.dp)
        ) {
            Column {
                detailsScreenViewModel.state.value.success?.let { productItem -> Content(productItem) }
            }
        }
    }
}

@Composable
fun Content(
    productItem: ProductItem
) {
    ProductItemsImage(productItem.yoastHeadJson.ogImage.firstOrNull()?.url ?: "")
    Spacer(modifier = Modifier.height(30.dp))
    ProductContent(productItem)
    Spacer(modifier = Modifier.height(20.dp))
    ProductAbout(productItem)
    Spacer(modifier = Modifier.height(40.dp))
    ProductAddToCart()
}

@Composable
fun ProductContent(
    productItem: ProductItem?
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        Column {
            Text(
                text = productItem?.yoastHeadJson?.ogTitle ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = pale_dark,
            )
            Text(
                text = productItem?.date ?: "",
                fontSize = 20.sp,
                color = Color.Black.copy(0.3f),
            )
        }

        Card(
            modifier = Modifier
                .width(130.dp)
                .height(100.dp),
            elevation = 15.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "100000﷼",
                    fontSize = 18.sp,
                    color = pale_dark,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.mitra))
                )
            }
        }
    }
}

@Composable
fun ProductAbout(productItem: ProductItem?) {
    Spacer(modifier = Modifier.padding(5.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.explain),
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Text(
            text = productItem?.yoastHeadJson?.ogDescription ?: "",
            fontSize = 23.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        AboutProductRow(
            title = stringResource(id = R.string.product_page_title),
            desc = productItem?.yoastHeadJson?.schema?.graph?.find {
                it.itemListElement.isEmpty().not()
            }?.itemListElement?.size?.toString() ?: ""
        )
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        AboutProductRow(title = stringResource(R.string.size_title), desc = "124*200")
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        AboutProductRow(title = stringResource(R.string.producer_title), desc = "اسم")
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        AboutProductRow(title = stringResource(R.string.producer_example), desc = "")
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        AboutProductRow(title = stringResource(R.string.explain_more), desc = "")
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.comments),
                    textAlign = TextAlign.Start,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.add_comment_title), fontSize = 22.sp)
                }
            }
        }
        Divider(modifier = Modifier.padding(vertical = 15.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.ask_title),
                    textAlign = TextAlign.Start,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold
                )

            }
            Box(
                contentAlignment = Alignment.CenterEnd,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(R.string.add_question_title), fontSize = 22.sp)
                }
            }
        }
    }
}

@Composable
fun AboutProductRow(
    title: String,
    desc: String
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = desc,
                textAlign = TextAlign.Start,
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.mitra))
            )
        }
    }
}

@Composable
fun ProductItemsImage(
    image: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(210.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            AsyncImage(
                model = image,
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}

@Composable
fun ProductAddToCart() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(ghost_white),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                modifier = Modifier
                    .offset(16.dp, (-40).dp)
                    .fillMaxWidth(0.2f)
                    .height(70.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                IconButton(
                    onClick = { },
                    Modifier.background(pale_black)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "",
                        tint = ghost_white
                    )

                }
            }
            ClickableText(
                text = AnnotatedString("اضافه کردن به سبد+"),
                Modifier.offset(16.dp, (-30).dp),
                onClick = {},
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.maktab)),
                    fontSize = 20.sp
                )
            )
        }
    }
}