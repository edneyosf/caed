package com.caed.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

@Composable
fun StatusInfo(date: String, time: String, color: Color, description: String){
    Row(modifier = Modifier.height(70.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(date, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(5.dp))
                Text(time, color = Colors.TEXT)
            }
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Line()
            Point(color = color)
            Line()
        }
        Spacer(modifier = Modifier.width(20.dp))
        Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.CenterEnd){
            Text(description, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        }
    }
}

@Composable
private fun ColumnScope.Line(){
    Box(modifier = Modifier
        .width(1.dp)
        .weight(1f)
        .background(color = Colors.BLACK.copy(alpha = 0.05f)))
}

@Composable
private fun Point(color: Color){
    Box(modifier = Modifier
        .width(15.dp)
        .height(15.dp)
        .background(color = color, shape = CircleShape))
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Default() = StatusInfo(date = "11/11/11", time = "11:11", color = Colors.YELLOW, description = "Sample")