package com.caed.uikit

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.caed.uikit.value.Colors

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun MyLoading() = CircularProgressIndicator(color = Colors.BLACK)