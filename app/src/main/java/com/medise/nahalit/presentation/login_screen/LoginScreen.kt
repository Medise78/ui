package com.medise.nahalit.presentation.login_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.medise.nahalit.R
import com.medise.nahalit.common.Routes
import com.medise.nahalit.presentation.ui.theme.*

@Composable
fun LoginScreen(
    navController: NavController,
    onLoginClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ConstraintLayout {
                val (image, loginForm) = createRefs()
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(280.dp)
                        .constrainAs(image) {
                            top.linkTo(loginForm.top)
                            bottom.linkTo(loginForm.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }) {
                    HeaderView()
                }
                Card(
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    backgroundColor = ghost_white,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 110.dp)
                        .constrainAs(loginForm) {
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    elevation = 0.dp
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(30.dp)
                    ) {
                        val loginAnnotatedString = buildAnnotatedString {
                            append(stringResource(id = R.string.login_text))
                            addStyle(
                                style = SpanStyle(
                                    color = dark_gray,
                                    fontFamily = FontFamily(Font(R.font.maktab))
                                ),
                                start = 0,
                                end = stringResource(id = R.string.login_text).length
                            )
                            addStyle(
                                style = SpanStyle(
                                    color = colorPrimary,
                                    fontFamily = FontFamily(Font(R.font.maktab))
                                ),
                                start = 0,
                                end = stringResource(id = R.string.login_word).length
                            )
                        }

                        Text(
                            text = loginAnnotatedString,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                        )
                        Text(
                            text = stringResource(R.string.email_address),
                            style = MaterialTheme.typography.subtitle1.copy(color = gray),
                            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
                        )
                        CustomStyleTextField(
                            placeHolder = stringResource(id = R.string.email_address),
                            leadingIconId = R.drawable.ic_email,
                            keyboardType = KeyboardType.Email,
                            visualTransformation = VisualTransformation.None,
                            imeAction = ImeAction.Next
                        )
                        Text(
                            text = stringResource(R.string.password),
                            style = MaterialTheme.typography.subtitle1.copy(color = gray)
                        )
                        CustomStyleTextField(
                            placeHolder = stringResource(id = R.string.password),
                            leadingIconId = R.drawable.ic_password,
                            keyboardType = KeyboardType.Password,
                            visualTransformation = PasswordVisualTransformation(),
                            imeAction = ImeAction.Done
                        )
                        Text(
                            text = stringResource(R.string.forgot_password),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.subtitle2.copy(color = colorPrimary),
                            fontSize = 16.sp
                        )
                        Button(
                            onClick = onLoginClick, modifier = Modifier
                                .padding(top = 30.dp, bottom = 34.dp)
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
                        ) {
                            Text(
                                text = stringResource(R.string.login),
                                color = Color.White,
                                style = MaterialTheme.typography.button,
                                fontSize = 22.sp
                            )
                        }
                        val signInAnnotation = buildAnnotatedString {
                            append(stringResource(id = R.string.sign_in_text))
                            addStyle(
                                style = SpanStyle(
                                    color = light_gray,
                                    fontFamily = FontFamily(Font(R.font.maktab))
                                ),
                                start = 0,
                                end = stringResource(id = R.string.sign_in_text).length
                            )
                            addStyle(
                                style = SpanStyle(
                                    color = colorPrimary,
                                    fontFamily = FontFamily(Font(R.font.maktab)),
                                    textDecoration = TextDecoration.Underline,
                                ),
                                start = stringResource(id = R.string.sign_in_text).indexOf(
                                    stringResource(id = R.string.sign_in)
                                ),
                                end = stringResource(id = R.string.sign_in_text).length
                            )
                        }

                        TextButton(onClick = {
                            navController.navigate(Routes.SignupScreen.route)
                        }) {
                            Text(
                                text = signInAnnotation,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 18.sp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun HeaderView() {

    val header = buildAnnotatedString {
        append(stringResource(id = R.string.header))
        addStyle(
            style = SpanStyle(
                color = dark_gray,
                fontFamily = FontFamily(Font(R.font.maktab))
            ),
            start = 0,
            end = stringResource(id = R.string.header).length
        )
        addStyle(
            style = SpanStyle(
                color = colorPrimary,
                fontFamily = FontFamily(Font(R.font.maktab))
            ),
            start = 0,
            end = stringResource(id = R.string.header_name).length
        )
    }
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.img1),
            contentDescription = stringResource(R.string.pcImpg),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 0.dp)
        ) {
            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.seedling),
                contentDescription = stringResource(
                    R.string.seedling
                ),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 0.dp)
            )
            Text(
                text = header,
                color = Color.White,
                style = TextStyle(
                    fontSize = 55.sp,
                    letterSpacing = 0.sp
                ),
            )
        }
    }
}

@Composable
fun CustomStyleTextField(
    placeHolder: String,
    leadingIconId: Int,
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
        placeholder = { Text(text = placeHolder, fontSize = 18.sp) },
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Image(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .size(18.dp),
                        bitmap = ImageBitmap.imageResource(id = leadingIconId),  // material icon
                        colorFilter = ColorFilter.tint(colorPrimary),
                        contentDescription = "custom_text_field"
                    )
                    Canvas(
                        modifier = Modifier.height(24.dp)
                    ) {
                        // Allows you to draw a line between two points (p1 & p2) on the canvas.
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorPrimary,
            unfocusedBorderColor = Color.Transparent,
            focusedLabelColor = Color.White,
            trailingIconColor = Color.White,
//            disabledTextColor = NaviBlue
        ),
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
        visualTransformation = visualTransformation
    )
}