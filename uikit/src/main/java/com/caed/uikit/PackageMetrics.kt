package com.caed.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

@Composable
fun PackageMetrics(title: String, textA: String, textB: String, valueA: String, valueB: String, percentA: Float,
                   percentB: Float, color: Color){

    Column(modifier = Modifier
        .background(color = Colors.GREY1, shape = RoundedCornerShape(16.dp))
        .width(300.dp)
        .padding(20.dp)) {
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Percent(modifier = Modifier.weight(percentA / 100), color = color)
            Spacer(modifier = Modifier.width(5.dp))
            Percent(modifier = Modifier.weight(percentB / 100), color = Colors.GREYC)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Info(textA, valueA, percentA.toString(), color)
        Spacer(modifier = Modifier.height(15.dp))
        Info(textB, valueB, percentB.toString(), Colors.GREYC)
    }
}

@Composable
private fun Percent(modifier: Modifier, color: Color){
    Box(modifier
        .height(30.dp)
        .background(color = color, shape = RoundedCornerShape(10.dp)))
}

@Composable
private fun Info(text: String, value: String, percent: String, color: Color){
    val label = stringResource(id = R.string.text_packages)

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column{
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .background(color = color, shape = RoundedCornerShape(2.dp)))
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            }
            Row {
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = "$value $label", color = Colors.TEXT)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$percent%", fontSize = 16.sp, color = Colors.TEXT, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun Default() = PackageMetrics(
    title = "Sample",
    textA = "Sample", valueA = "Sample", percentA = 0.75f,
    textB = "Sample",  valueB = "Sample", percentB = 0.25f,
    color = Colors.YELLOW)