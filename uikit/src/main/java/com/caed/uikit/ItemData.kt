package com.caed.uikit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

@Composable
fun ItemData(label: String, text: String){
    Row(modifier = Modifier.padding(vertical = 20.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart){
            Text(label, fontSize = 16.sp, color = Colors.TEXT, fontWeight = FontWeight.Light, softWrap = true)
        }
        Spacer(modifier = Modifier.width(15.dp))
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterEnd){
            Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, softWrap = true)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Default() = ItemData(label = "LABEL", "Text")