package com.caed.uikit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caed.uikit.value.Colors

@Composable
fun BottomNavigation(){
    Row(modifier = Modifier
        .background(Color(0xFFFFFFFF))
        .padding(vertical = 12.dp, horizontal = 20.dp)){
        BottomNavigationItem(icon = Icons.Default.Home,
            label = stringResource(id = R.string.navigation_item_home), selected = true)
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationItem(icon = Icons.Default.Settings, label = stringResource(id = R.string.navigation_item_options))
        Spacer(modifier = Modifier.weight(1f))
        BottomNavigationItem(icon = Icons.Default.Info, label = stringResource(id = R.string.navigation_item_tutorials))
    }
}

@Composable
private fun BottomNavigationItem(icon: ImageVector, label: String, selected: Boolean = false){
    val iconColor = if(selected) Colors.BLACK else Colors.TEXT
    val color = if(selected) Color(0xFFCDE7EC) else Colors.TRANSPARENT
    val textColor = if(selected) Colors.BLACK else Colors.TEXT

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            Modifier
                .background(color = color, shape = RoundedCornerShape(16.dp))
                .padding(vertical = 5.dp, horizontal = 20.dp)){
            Icon(imageVector = icon, tint = iconColor, contentDescription = "")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(label, color = textColor)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun Default() = BottomNavigation()