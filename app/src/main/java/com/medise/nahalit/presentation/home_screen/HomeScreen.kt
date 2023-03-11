package com.medise.nahalit.presentation.home_screen

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.medise.nahalit.R
import com.medise.nahalit.common.MenuItems
import com.medise.nahalit.common.Routes
import com.medise.nahalit.presentation.dashboard.CustomBottomBar
import com.medise.nahalit.presentation.dashboard.CustomTopAppBar
import com.medise.nahalit.presentation.home_screen.components.DrawerBody
import com.medise.nahalit.presentation.home_screen.components.DrawerHeader
import com.medise.nahalit.presentation.home_screen.components.ProductCard
import com.medise.nahalit.presentation.home_screen.components.SocialMediaIcons
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield


@Composable
fun HomeScreen(
    navController: NavController,
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentRoute = navController.currentBackStackEntryAsState()
    val state = currentRoute.value?.destination?.route
    val scrollState = rememberLazyGridState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CustomTopAppBar() {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerContent = {
            Column(modifier = Modifier.fillMaxSize()) {
                DrawerHeader()
                Spacer(modifier = Modifier.height(5.dp))
                DrawerBody(items = MenuItems.list) {
                    when(it.id){
                        10 -> {
                            navController.navigate(Routes.RecruitmentScreen.route)
                        }
                    }
                }
            }
        },
        backgroundColor = colorPrimary,
        drawerGesturesEnabled = !(state == "login_screen" || state == "signup_screen" || state == "splash_screen"),
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
            HomeDashboard(scrollState, navController)
        }
    }
}

@Composable
fun HomeDashboard(scrollState: LazyGridState, navController: NavController) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        columns = GridCells.Fixed(2),
        state = scrollState
    ) {
        item(span = { GridItemSpan(2) }) {
            Box(modifier = Modifier.fillMaxWidth()) {
                SlidingBanner()
            }
        }
        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.products),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        items(10) {
            ProductCard(
                image = R.drawable.img1,
                title = "محصول۱",
                description = "",
                price = "10000",
                onCardClick = {
                    navController.navigate(Routes.DetailScreen.route)
                }) {
            }
        }

        item(span = { GridItemSpan(2) }) {
            Spacer(modifier = Modifier.height(5.dp))
        }

        item(span = { GridItemSpan(2) }) {
            Box {
                Text(
                    text = stringResource(R.string.entertainment),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp),
                    textAlign = TextAlign.Start,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            }
        }


        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.one_shot_explain),
                    textAlign = TextAlign.Start,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Black
                )
            }
        }

        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.seo_web),
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp
                )
            }
        }

        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.web_desc),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontSize = 18.sp
                )
            }
        }

        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.mobile_title),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.mobile_desc),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontSize = 18.sp
                )
            }
        }

        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.grafic_title),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontSize = 20.sp
                )
            }
        }
        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = stringResource(R.string.grafic_desc),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 15.dp),
                    fontSize = 18.sp
                )
            }
        }
        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Divider(modifier = Modifier.fillMaxWidth(0.85f), color = Color.Black.copy(0.25f))
            }
        }
        item(span = { GridItemSpan(2) }) {
            SocialMediaIcons()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun SlidingBanner() {
    val pagerState = rememberPagerState()
    LaunchedEffect(key1 = pagerState) {
        while (true) {
            yield()
            delay(3000)
            tween<Float>(650)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount)
            )
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = 3,
            state = pagerState,
            itemSpacing = 20.dp
        ) { page ->
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.img),
                contentDescription = "index",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(205.dp)
                    .padding(20.dp)
                    .clip(shape = RoundedCornerShape(20.dp))

            )
        }
        HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier.padding(16.dp))
    }
}
