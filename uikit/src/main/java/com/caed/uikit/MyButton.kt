package com.caed.uikit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

@Composable
fun MyButton(value: String, onClick: () -> Unit){
    val colors = ButtonDefaults.textButtonColors(containerColor = Colors.YELLOW)
    val padding = PaddingValues(vertical = 20.dp)

    TextButton(
        contentPadding = padding,
        colors = colors,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(0.dp),
        onClick = onClick) {
        Content(value)
    }
}

@Composable
private fun Content(value: String){
    Text(value, color = Colors.BLACK, fontWeight = FontWeight.W300, fontSize = 20.sp)
}

@Preview
@Composable
private fun Default(){
    val content = "Sample"

    MyButton(content, {})
}