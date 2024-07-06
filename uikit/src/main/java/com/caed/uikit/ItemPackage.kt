package com.caed.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

@Composable
fun ItemPackage(title: String, received: Boolean = false, devolution: Boolean = false, onClick: () -> Unit){
    Row (modifier = Modifier
        .clickable { onClick() }
        .padding(vertical = 20.dp, horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically){
        Column {
            Text(text = title, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Indicator(color = if(received) Colors.RECEIVED else Colors.GREYC)
                Spacer(modifier = Modifier.width(5.dp))
                Indicator(color = if(devolution) Colors.DEVOLUTION else Colors.GREYC)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight, tint = Colors.TEXT, contentDescription = "")
    }
}

@Composable
private fun Indicator(color: Color){
    Box(modifier = Modifier
        .width(50.dp)
        .height(8.dp)
        .background(color = color, shape = RoundedCornerShape(5.dp)))
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun Default() = ItemPackage(title = "Sample") {}