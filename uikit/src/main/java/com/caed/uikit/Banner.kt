package com.caed.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Banner(){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
        Background()
        Spacer(modifier = Modifier.height(10.dp))
        Logo()
    }
}

@Composable
private fun Background(){
    val resource = painterResource(id = R.drawable.background)
    val description = stringResource(id = R.string.banner_description)

    Image(
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth,
        painter = resource,
        contentDescription = description)
}

@Composable
private fun Logo(){
    val resource = painterResource(id = R.drawable.logo)
    val description = stringResource(id = R.string.logo_description)

    Image(painter = resource, contentDescription = description)
}