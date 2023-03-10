package com.medise.nahalit.presentation.home_screen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.R
import com.medise.nahalit.presentation.ui.theme.colorPrimary

@Composable
fun CustomButton(
    onBuyBtnClick: () -> Unit
) {
    Button(
        onClick = onBuyBtnClick,
        modifier = Modifier
            .height(43.dp)
            .width(95.dp)
            .offset((20).dp),
        elevation = null,
        shape = RoundedCornerShape(topStartPercent = 50),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorPrimary
        )
    ) {
        Text(
            text = stringResource(id = R.string.buy),
            fontSize = 19.sp,
            color = Color.White
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = stringResource(id = R.string.buy),
            modifier = Modifier.padding(start = 5.dp),
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestBtn() {
    CustomButton {

    }
}