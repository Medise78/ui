package com.medise.nahalit.presentation.profile_screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogBox(
    enabled:Boolean = false,
    title: String,
    hint:String,
    onDismiss: () -> Unit,
    onSubmitClicked: () -> Unit
) {
    if (enabled){
        Dialog(onDismissRequest = onDismiss) {
            Card(
                modifier = Modifier.wrapContentSize(),
                elevation = 8.dp,
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    MainTextField(edtValue = "", hint = hint, OnValueChanges = {})
                    MainTextField(edtValue = "", hint = hint, OnValueChanges = {})
                    // Buttons
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(onClick = onDismiss) { Text(text = "لغو") }
                        Spacer(modifier = Modifier.width(4.dp))
                        TextButton(onClick = {
                            onSubmitClicked()
                        }) { Text(text = "تایید") }
                    }
                }
            }
        }
    }
}

@Composable
fun MainTextField(edtValue: String, hint: String, OnValueChanges: (String) -> Unit) {
    OutlinedTextField(
        label = { Text(hint) },
        value = edtValue,
        singleLine = true,
        onValueChange = OnValueChanges,
        placeholder = { Text(text = "Write something") },
        modifier = Modifier.fillMaxWidth(0.9f),
        shape = MaterialTheme.shapes.medium,
        maxLines = 2
    )
}