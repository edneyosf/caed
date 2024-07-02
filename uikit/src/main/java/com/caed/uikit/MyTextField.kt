package com.caed.uikit

import androidx.compose.material3.TextField
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun MyTextField(value: String, onValueChange: (TextFieldValue) -> Unit){
    TextField(TextFieldValue(value), onValueChange = onValueChange)
}

@Preview
@Composable
private fun Default() = MyTextField("", {})