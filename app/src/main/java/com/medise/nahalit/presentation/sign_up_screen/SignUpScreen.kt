package com.medise.nahalit.presentation.sign_up_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.medise.nahalit.R
import com.medise.nahalit.presentation.login_screen.CustomStyleTextField
import com.medise.nahalit.presentation.login_screen.HeaderView
import com.medise.nahalit.presentation.ui.theme.*

@Composable
fun SignupScreen(
    onSignupClick: () -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        userScrollEnabled = false
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
                        Text(
                            text = stringResource(id = R.string.sign_in),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 20.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp
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
                            text = stringResource(R.string.phone_number),
                            style = MaterialTheme.typography.subtitle1.copy(color = gray),
                            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp)
                        )
                        CustomStyleTextField(
                            placeHolder = stringResource(id = R.string.phone_number),
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
                            imeAction = ImeAction.Next
                        )
                        Text(
                            text = stringResource(R.string.pass_again),
                            style = MaterialTheme.typography.subtitle1.copy(color = gray)
                        )
                        CustomStyleTextField(
                            placeHolder = stringResource(id = R.string.pass_again),
                            leadingIconId = R.drawable.ic_password,
                            keyboardType = KeyboardType.Password,
                            visualTransformation = PasswordVisualTransformation(),
                            imeAction = ImeAction.Done
                        )
                        Button(
                            onClick = onSignupClick, modifier = Modifier
                                .padding(top = 30.dp, bottom = 34.dp)
                                .align(Alignment.CenterHorizontally)
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
                        ) {
                            Text(
                                text = stringResource(R.string.sign_in),
                                color = Color.White,
                                style = MaterialTheme.typography.button,
                                fontSize = 22.sp
                            )
                        }
                    }
                }
            }
        }
    }
}