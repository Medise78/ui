package com.medise.nahalit.presentation.about_screen.component

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView

@Composable
fun MapView(
    modifier: Modifier = Modifier,
    onReady: (GoogleMap) -> Unit
) {
    val context = LocalContext.current

    val mapView = remember {
        MapView(context)
    }

    val lifecycle = LocalLifecycleOwner.current.lifecycle

    lifecycle.addObserver(rememberMapLifecycle(map = mapView))

    AndroidView(
        factory = {
            mapView.apply {
                mapView.getMapAsync { googleMap ->
                    onReady(googleMap)
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun rememberMapLifecycle(map: MapView): LifecycleEventObserver {

    return remember(map) {
        LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> map.onCreate(Bundle())
                Lifecycle.Event.ON_START -> map.onStart()
                Lifecycle.Event.ON_RESUME -> map.onResume()
                Lifecycle.Event.ON_PAUSE -> map.onPause()
                Lifecycle.Event.ON_STOP -> map.onStop()
                Lifecycle.Event.ON_DESTROY -> map.onDestroy()
                else -> throw IllegalStateException()
            }
        }
    }
}



//val launcher = rememberLauncherForActivityResult(
//    contract = ActivityResultContracts.RequestPermission(),
//    onResult = { isGranted ->
//        if (isGranted) {
//            phoneCall(SHOPNUMBER, context)
//        } else {
//            Toast.makeText(
//                context,
//                "The app requires phone call permission to be able to call the shop physical store.",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//)


//when (PackageManager.PERMISSION_GRANTED) {
//    ContextCompat.checkSelfPermission(
//        context,
//        Manifest.permission.CALL_PHONE
//    ) -> {
//        // Some works that require permission
//        phoneCall(SHOPNUMBER, context)
//    }
//    else -> {
//        // Asking for permission
//        launcher.launch(Manifest.permission.CALL_PHONE)
//    }
//}