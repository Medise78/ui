package com.medise.nahalit.presentation.home_screen.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.medise.nahalit.R
import com.medise.nahalit.presentation.ui.theme.colorPrimary

@Composable
fun ExpandableSearchView(
    searchDisplay: String,
    onSearchDisplayChanged: (String) -> Unit,
    onSearchDisplayClosed: () -> Unit,
    modifier: Modifier = Modifier,
    expandedInitially: Boolean = false,
    tint: Color = MaterialTheme.colors.onPrimary,
    isShow: Boolean = true,
    onSearchIconClick: () -> Unit
) {
    val (expanded, onExpandedChanged) = remember {
        mutableStateOf(expandedInitially)
    }


    if (isShow) {
        Crossfade(targetState = expanded) { isSearchFieldVisible ->
            when (isSearchFieldVisible) {
                true -> ExpandedSearchView(
                    searchDisplay = searchDisplay,
                    onSearchDisplayChanged = onSearchDisplayChanged,
                    onSearchDisplayClosed = onSearchDisplayClosed,
                    onExpandedChanged = onExpandedChanged,
                    modifier = modifier,
                    tint = tint,
                    onTrailIconClick = onSearchIconClick
                )

                false -> CollapsedSearchView(
                    onExpandedChanged = onExpandedChanged,
                    modifier = modifier,
                    tint = tint,
                    onSearchIconClick = onSearchIconClick
                )
            }
        }
    }
}

@Composable
fun SearchIcon(iconTint: Color) {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "search icon",
        tint = iconTint
    )
}

@Composable
fun CollapsedSearchView(
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colors.onPrimary,
    onSearchIconClick: () -> Unit
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onExpandedChanged(true);onSearchIconClick() }) {
            SearchIcon(iconTint = tint)
        }
    }
}

@Composable
fun ExpandedSearchView(
    searchDisplay: String,
    onSearchDisplayChanged: (String) -> Unit,
    onSearchDisplayClosed: () -> Unit,
    onExpandedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = MaterialTheme.colors.onPrimary,
    onTrailIconClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current




    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {
            onExpandedChanged(false)
            onSearchDisplayClosed()
        }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "back icon",
                tint = tint
            )
        }
        CustomTextField(searchText = searchDisplay, onSearchText = onSearchDisplayChanged)

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomTextField(
    searchText: String,
    onSearchText: (String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val textFieldFocusRequester = remember { FocusRequester() }

    var textFieldValue by remember {
        mutableStateOf(TextFieldValue(searchText, TextRange(searchText.length)))
    }
    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 5.dp, bottom = 5.dp)
            .border(
                1.dp,
                Color.Black.copy(0.5f),
                shape = RoundedCornerShape(50.dp)
            )
            .background(Color.White, RoundedCornerShape(50.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 8.dp, end = 8.dp),
                tint = Color.White
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    value = textFieldValue,
                    onValueChange = { textFieldValue = it },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { keyboardController?.hide();focusManager.clearFocus() }),
                    maxLines = 1,
                    textStyle = TextStyle(
                        color = Color.Black,
                        textAlign = TextAlign.Start,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(textFieldFocusRequester),
                    singleLine = true,
                )

                if (textFieldValue.text.isEmpty()) {
                    Text(
                        text = "جستجو...", color = Color.Black.copy(0.5F),
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

