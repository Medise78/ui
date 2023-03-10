package com.medise.nahalit.presentation.profile_screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.canhub.cropper.CropImageContract
import com.medise.nahalit.R
import com.medise.nahalit.presentation.dashboard.CustomBottomBar
import com.medise.nahalit.presentation.profile_screen.component.DialogBox
import com.medise.nahalit.presentation.profile_screen.component.ProfileColumnRow
import com.medise.nahalit.presentation.profile_screen.component.ProfileTopAppBar
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ProfileTopAppBar(title = stringResource(id = R.string.profile)) {
                navController.navigateUp()
            }
        },
        backgroundColor = colorPrimary,
        bottomBar = {
            if (scrollState.value < 1)
                CustomBottomBar(navController = navController)
        }
    ) {
        it.calculateBottomPadding()
        Card(
            backgroundColor = ghost_white,
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileCard(scrollState = scrollState)
        }
    }
}

@Composable
fun ProfileCard(
    scrollState: ScrollState
) {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher =
        rememberLauncherForActivityResult(contract = CropImageContract(), onResult = { result ->
            if (result.isSuccessful) {
                imageUri = result.uriContent
            }
        })
    var enable by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        backgroundColor = ghost_white,
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .height(225.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        launcher.launch(null)
                    }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "name",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.height(32.dp))
            Divider()

            DialogBox(
                enabled = enable,
                title = stringResource(id = R.string.fname_lname),
                hint = "",
                onDismiss = { enable = !enable }) {
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .verticalScroll(state = scrollState)
            ) {
                ProfileColumnRow(text = stringResource(R.string.recruitment_form)) {

                }
                Divider()
                Spacer(modifier = Modifier.padding(vertical = 10.dp))
                Text(
                    text = stringResource(R.string.personality_information),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.SemiBold
                )
                ProfileColumnRow(text = stringResource(R.string.fname_lname)) {
                    enable = !enable
                }
                Divider()
                ProfileColumnRow(text = stringResource(id = R.string.phone_number)) {

                }
                Divider()
                ProfileColumnRow(text = stringResource(R.string.payment_back)) {

                }
                Divider()
                ProfileColumnRow(text = stringResource(R.string.zip_code)) {

                }
                Divider()
                ProfileColumnRow(text = stringResource(R.string.static_phone)) {

                }
                Divider()
                ProfileColumnRow(text = stringResource(R.string.email)) {

                }
                Divider()
                ProfileColumnRow(text = stringResource(R.string.password)) {

                }
            }
        }
    }
}

