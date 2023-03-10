package com.medise.nahalit.presentation.about_screen

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.medise.nahalit.presentation.about_screen.component.AboutTopAppBar
import com.medise.nahalit.presentation.home_screen.components.SocialMediaIcons
import com.medise.nahalit.R
import com.medise.nahalit.presentation.about_screen.component.MapView
import com.medise.nahalit.presentation.ui.theme.pale_dark

@Composable
fun AboutScreen(
    navController: NavController
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            AboutTopAppBar(title = "درباره ی ما" , color = pale_dark) {
                navController.navigateUp()
            }
        }
    ) {
        Divider()
        it.calculateBottomPadding()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            AboutText(
                title = "درباره ی ما",
                desc = stringResource(id = R.string.grafic_desc)
            )
            Divider(modifier = Modifier.padding(vertical = 15.dp))
            AboutText(
                title = "درباره ی ما",
                desc = stringResource(id = R.string.grafic_desc)
            )
            Divider(modifier = Modifier.padding(vertical = 15.dp))
            AboutText(
                title = "درباره ی ما",
                desc = stringResource(id = R.string.grafic_desc)
            )
            Divider(modifier = Modifier.padding(vertical = 15.dp))
            AboutText(
                title = "درباره ی ما",
                desc = stringResource(id = R.string.grafic_desc)
            )
            Divider(modifier = Modifier.padding(vertical = 15.dp))
            AboutText(
                title = "درباره ی ما",
                desc = stringResource(id = R.string.grafic_desc)
            )
            Divider(modifier = Modifier.padding(vertical = 15.dp))
            CallInformation(title = "اطلاعات تماس", context = context)
            Divider(modifier = Modifier.padding(vertical = 15.dp))
            AboutText(
                title = stringResource(id = R.string.address),
                desc = "تهران-میدان ازادی-پلاک۳-شعبه۲"
            )
            MapView(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .padding(10.dp),
                onReady = { googleMap ->
                    googleMap.uiSettings.isZoomControlsEnabled = true

                    val centerLocation = LatLng(35.0, 25.0)

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLocation, 15f))
                    val markerOptions = MarkerOptions()
                        .title("nahalIT")
                        .position(centerLocation)
                    googleMap.addMarker(markerOptions)
                }
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 15.dp),
                color = Color.Black.copy(0.25f)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                SocialMediaIcons()
            }
        }
    }
}


@Composable
fun AboutText(
    title: String,
    desc: String
) {
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
            )
        }
        Text(
            text = desc,
            fontSize = 20.sp
        )
    }
}

@Composable
fun CallInformation(
    title: String,
    context: Context
) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGrant ->
            if (isGrant) {
                phoneCall("0916002220233", context)
            } else {
                Toast.makeText(context, "نیاز به گارانتی", Toast.LENGTH_SHORT).show()
            }
        }
    )


    Column {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
                tint = MaterialTheme.colors.primary,
                imageVector = Icons.Filled.Call,
                contentDescription = Icons.Filled.Call.name,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                modifier = Modifier
                    .align(CenterVertically)
                    .clickable {
                        when (PackageManager.PERMISSION_GRANTED) {
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.CALL_PHONE
                            ) -> {
                                phoneCall("0916002220233", context)
                            }
                            else -> {
                                launcher.launch(Manifest.permission.CALL_PHONE)
                            }
                        }
                    },
                text = "0916002220233",
                fontFamily = FontFamily(Font(R.font.mitra)),
                fontSize = 25.sp
            )
        }
    }
}

fun phoneCall(number: String, context: Context) {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$number"))
    context.startActivity(intent)
}