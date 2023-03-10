package com.medise.nahalit.presentation.dashboard

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.medise.nahalit.R
import com.medise.nahalit.common.Routes
import com.medise.nahalit.presentation.spalsh_screen.SplashScreen
import com.medise.nahalit.presentation.about_screen.AboutScreen
import com.medise.nahalit.presentation.buy_screen.BuyScreen
import com.medise.nahalit.presentation.detail_screen.DetailScreen
import com.medise.nahalit.presentation.home_screen.HomeScreen
import com.medise.nahalit.presentation.home_screen.components.ExpandableSearchView
import com.medise.nahalit.presentation.login_screen.LoginScreen
import com.medise.nahalit.presentation.profile_screen.ProfileScreen
import com.medise.nahalit.presentation.recruitment_screen.RecruitmentScreen
import com.medise.nahalit.presentation.sign_up_screen.SignupScreen
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white


@Composable
fun Dashboard(
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()
    val scrollState = rememberLazyGridState()
    val scaffoldState = rememberScaffoldState()
    val navControl = navController.currentBackStackEntryAsState()
    val state = navControl.value?.destination?.route
    val bottomBarState = rememberSaveable {
        mutableStateOf(true)
    }


    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            scaffoldState = scaffoldState,
            content = { paddingValues ->
                paddingValues.calculateBottomPadding()
                NavHost(
                    navController = navController,
                    startDestination = Routes.SplashScreen.route
                ) {
                    composable(Routes.SplashScreen.route) {
                        EnterAnimation {
                            SplashScreen(navController = navController)
                        }
                    }
                    composable(Routes.LoginScreen.route) {
                        EnterAnimation {
                            LoginScreen(navController) {
                                navController.navigate(Routes.HomeScreen.route)
                            }
                        }
                    }
                    composable(Routes.DetailScreen.route) {
                        EnterAnimation {
                            DetailScreen(navController)
                        }
                    }
                    composable(Routes.SignupScreen.route) {
                        EnterAnimation {
                            SignupScreen {

                            }
                        }
                    }
                    composable(Routes.HomeScreen.route) {
                        EnterAnimation {
                            HomeScreen(navController)
                        }
                    }
                    composable(Routes.BuyScreen.route) {
                        EnterAnimation {
                            BuyScreen(navController)
                        }
                    }
                    composable(Routes.ProfileScreen.route) {
                        EnterAnimation {
                            ProfileScreen(navController = navController)
                        }
                    }
                    composable(Routes.FavoriteScreen.route) {
                        Text(text = "")

                    }
                    composable(Routes.ContactScreen.route) {
                        EnterAnimation {
                            AboutScreen(navController = navController)
                        }
                    }
                    composable(Routes.RecruitmentScreen.route){
                        EnterAnimation {
                            RecruitmentScreen()
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun CustomBottomBar(
    navController: NavController,
    isShow: MutableState<Boolean> = mutableStateOf(true),
    bottomBarStatus: MutableState<Boolean> = mutableStateOf(true)
) {
    val listItems = Routes.list
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (bottomBarStatus.value) {
        if (isShow.value) {
            Card(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .height(64.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black.copy(0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {

                BottomNavigation(
                    backgroundColor = Color.White,
                ) {
                    listItems.forEachIndexed { index, label ->
                        BottomNavigationItem(
                            selected = currentRoute == label.route,
                            onClick = {
                                if (currentRoute != label.route) {
                                    navController.navigate(label.route)
                                }
                            },
                            label = {
                                Text(
                                    text = label.name,
                                    textAlign = TextAlign.Center,
                                    fontSize = 14.sp
                                )
                            },
                            alwaysShowLabel = false,
                            icon = {
                                TabIcons(
                                    icon = label.icon ?: Icons.Default.Menu,
                                    isTintColor = currentRoute == label.route
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TabIcons(
    icon: ImageVector, isTintColor: Boolean
) {
    if (isTintColor) {
        Column {
            Image(
                imageVector = icon,
                contentDescription = icon.name,
                modifier = Modifier.wrapContentSize(),
                colorFilter = ColorFilter.tint(
                    colorPrimary
                ),
                contentScale = ContentScale.Fit
            )
        }

    } else {
        Image(
            imageVector = icon,
            contentDescription = icon.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier.wrapContentSize()
        )
    }
}

@Composable
fun CustomTopAppBar(
    isShow: MutableState<Boolean> = mutableStateOf(true),
    onMenuItemClick: () -> Unit = {}
) {
    val textField = remember {
        mutableStateOf("")
    }
    var isUserShow by remember {
        mutableStateOf(false)
    }
    if (isShow.value) {
        TopAppBar(
            elevation = 0.dp,
            modifier = Modifier.fillMaxWidth(),
            title = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(id = R.string.header),
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    ExpandableSearchView(
                        searchDisplay = textField.value,
                        onSearchDisplayChanged = {
                            textField.value = it
                        },
                        onSearchDisplayClosed = {
                            isUserShow = !isUserShow
                        },
                        isShow = true,
                        onSearchIconClick = {
                            isUserShow = !isUserShow
                        }
                    )

                    if (!isUserShow) {
                        IconButton(
                            onClick = onMenuItemClick,
                            modifier = Modifier.align(Alignment.CenterStart)
                        ) {
                            Image(
                                imageVector = Icons.Default.Menu,
                                contentDescription = stringResource(R.string.Menu),
                                colorFilter = ColorFilter.tint(ghost_white)
                            )
                        }
                    }
                }
            },
            backgroundColor = colorPrimary,
        )
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visible = true,
        enter = slideInVertically(
            initialOffsetY = { -80 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
        content = content,
        initiallyVisible = false
    )
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

