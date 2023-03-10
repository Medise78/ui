package com.medise.nahalit.presentation.recruitment_screen.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.pale_black

@Composable
fun RecruitmentTextField(
    placeHolder: String,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    imeAction: ImeAction
) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        value = textState.value,
        onValueChange = { valueChanged ->
            textState.value = valueChanged
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus()}),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            unfocusedBorderColor = Color.Black.copy(0.3f),
            focusedLabelColor = Color.Black,
            cursorColor = pale_black
        ),
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
        visualTransformation = visualTransformation,
        label = {
            Text(text = placeHolder , fontSize = 18.sp)
        }
    )
}