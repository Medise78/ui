package com.medise.nahalit.presentation.recruitment_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.R
import com.medise.nahalit.presentation.login_screen.CustomStyleTextField
import com.medise.nahalit.presentation.profile_screen.component.ProfileTopAppBar
import com.medise.nahalit.presentation.recruitment_screen.component.ExposedSelectionMenu
import com.medise.nahalit.presentation.recruitment_screen.component.RecruitmentTextField
import com.medise.nahalit.presentation.ui.theme.colorPrimary
import com.medise.nahalit.presentation.ui.theme.ghost_white

@Composable
fun RecruitmentScreen(

) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ProfileTopAppBar(title = stringResource(R.string.recruitment)) {

            }
        },
        backgroundColor = colorPrimary
    ) {
        it.calculateBottomPadding()
        Card(
            backgroundColor = ghost_white,
            shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                RecruitmentRequest()
                Spacer(modifier = Modifier.padding(vertical = 15.dp))
                PersonalDetail {

                }
            }
        }
    }
}

@Composable
fun RecruitmentRequest() {
    Column(
        modifier = Modifier
            .padding(top = 40.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,

            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "شغل درخواستی",
                    fontSize = 18.sp
                )
                Divider()
                Text(
                    text = "---",
                    fontSize = 18.sp,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "وضعیت درخواست",
                    fontSize = 18.sp
                )
                Divider()
                Text(
                    text = "---",
                    fontSize = 18.sp,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "رضایت سنجی",
                    fontSize = 18.sp
                )
                Divider()
                Text(
                    text = "---",
                    fontSize = 18.sp,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "جزيیات",
                    fontSize = 18.sp
                )
                Divider()
                Text(
                    text = "---",
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Composable
fun PersonalDetail(
    onSubmit: () -> Unit
) {
    Column {
        Text(
            text = stringResource(
                R.string.neccesery_information
            ),
            fontSize = 25.sp
        )
        Divider()
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        RecruitmentTextField(
            placeHolder = stringResource(id = R.string.fname_lname),
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        RecruitmentTextField(
            placeHolder = stringResource(id = R.string.zip_code),
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        RecruitmentTextField(
            placeHolder = stringResource(id = R.string.password),
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        ExposedSelectionMenu(
            title = "فرصت های شغلی",
            index = 0,
            options = listOf("1", "2"),
            onSelected = {

            }
        )
        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        Text(
            text = stringResource(R.string.call_information),
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        RecruitmentTextField(
            placeHolder = stringResource(id = R.string.email_address),
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            imeAction = ImeAction.Next
        )
        Spacer(modifier = Modifier.padding(vertical = 7.dp))
        RecruitmentTextField(
            placeHolder = stringResource(id = R.string.phone_number),
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            imeAction = ImeAction.Next
        )

        Spacer(modifier = Modifier.padding(vertical = 15.dp))
        Button(
            onClick = onSubmit, modifier = Modifier
                .padding(top = 5.dp, bottom = 40.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            shape = RoundedCornerShape(3.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
        ) {
            Text(
                text = stringResource(R.string.upload_resume),
                color = Color.White,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                fontSize = 18.sp
            )
        }
        Divider()
        Spacer(modifier = Modifier.padding(vertical = 7.dp))


        Button(
            onClick = onSubmit, modifier = Modifier
                .padding(top = 30.dp, bottom = 34.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary)
        ) {
            Text(
                text = stringResource(R.string.save_information),
                color = Color.White,
                style = MaterialTheme.typography.button,
                fontSize = 22.sp
            )
        }
    }
}