package com.caed.uikit

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.caed.uikit.value.Colors

@Composable
fun BaseUI (content: @Composable () -> Unit) {
    val modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()

    Surface(modifier = modifier, content = content, color = Colors.WHITE)
}