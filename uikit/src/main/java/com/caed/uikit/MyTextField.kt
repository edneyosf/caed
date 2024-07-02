package com.caed.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

@Composable
fun MyTextField(value: String, label: String, onValueChange: (String) -> Unit){
    val colors = TextFieldDefaults.colors(
        cursorColor = Colors.BLACK,
        unfocusedContainerColor = Colors.GREY0,
        focusedContainerColor = Colors.GREY0,
        focusedIndicatorColor = Colors.TRANSPARENT,
        unfocusedIndicatorColor = Colors.TRANSPARENT,
        disabledIndicatorColor = Colors.TRANSPARENT
    )

    Column {
        Label(label)
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            colors = colors,
            shape = RoundedCornerShape(10.dp),
            onValueChange = onValueChange
        )
    }
}

@Composable
private fun Label(value: String){
    Text(value, color = Colors.TEXT, fontSize = 16.sp)
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Default(){
    val label = "Sample"
    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .background(Colors.WHITE)
        .padding(10.dp)){
        MyTextField(text, label = label, onValueChange = { text = it })
    }
}