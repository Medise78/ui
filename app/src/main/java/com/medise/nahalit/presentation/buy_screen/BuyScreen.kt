package com.medise.nahalit.presentation.buy_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white
import com.medise.nahalit.presentation.ui.theme.pale_black
import com.medise.nahalit.R
import com.medise.nahalit.presentation.buy_screen.component.ItemBuyCard
import com.medise.nahalit.presentation.dashboard.CustomBottomBar
import com.medise.nahalit.presentation.profile_screen.component.ProfileTopAppBar

@Composable
fun BuyScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberLazyListState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ProfileTopAppBar(title = stringResource(R.string.buy_screen)) {

            }
        },
        backgroundColor = colorPrimary,
        bottomBar = {
            if (scrollState.firstVisibleItemIndex < 1)
                CustomBottomBar(navController = navController)
        }
    ) {
        it.calculateBottomPadding()
        Card(
            backgroundColor = ghost_white,
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
                DeleteCart()
                LazyColumn(
                    state = scrollState
                ) {
                    items(5) {
                        ItemBuyCard(
                            painter = R.drawable.ic_launcher_background,
                            title = "طراحی سایت",
                            price = "500",
                            size = "55"
                        )
                        Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    }
                    item {
                        BuyButtonWithTotalItems{

                        }
                    }
                }
            }
        }
    }
}


@Composable
fun BuyButtonWithTotalItems(
    onBuyClick:() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Divider(color = colorPrimary, thickness = 1.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "۳ محصول",
                fontSize = 22.sp,
                color = colorPrimary
            )

            Text(
                text = "650000﷼",
                fontSize = 18.sp,
                color = pale_black,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.mitra))
            )
        }

        Button(
            onClick = onBuyClick, modifier = Modifier
                .padding(top = 30.dp, bottom = 34.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
        ) {
            Text(
                text = stringResource(R.string.buy),
                color = Color.White,
                style = MaterialTheme.typography.button,
                fontSize = 22.sp
            )
        }
    }
}


@Composable
fun DeleteCart() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            buildAnnotatedString {
                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                    withStyle(
                        style = SpanStyle(
                            color = colorPrimary,
                            fontSize = 24.sp
                        )
                    ) {
                        append("نهال\n")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = pale_black,
                            fontSize = 24.sp
                        )
                    ) {
                        append("آی تی")
                    }
                }
            }
        )

        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_shop),
                contentDescription = "ic",
                tint = pale_black
            )
        }
    }
}