package com.caed.uikit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BackAppBar(title: String, onBackPressed: () -> Unit){
    val description = stringResource(id = R.string.back_button)
    val icon = Icons.AutoMirrored.Default.ArrowBack
    val verticalAlignment = Alignment.CenterVertically
    val modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 15.dp, horizontal = 5.dp)

    Row(modifier = modifier, verticalAlignment = verticalAlignment) {
        IconButton(onClick = onBackPressed) {
            Icon(imageVector = icon, contentDescription = description)
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Default() = BackAppBar(title = "Sample") {}