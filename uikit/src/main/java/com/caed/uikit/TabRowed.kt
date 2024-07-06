package com.caed.uikit

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.uikit.value.Colors

private const val durationIndicatorAnimation = 250
private val easingIndicatorAnimation = FastOutSlowInEasing
private val marginIndicator = 15.dp
private val heightIndicator = 3.dp
private val radiusIndicator = 12.dp

@Composable
fun TabRowed(indexSelected: Int, items: List<String>,
             onChanged: (index: Int) -> Unit) {

    val unselectedColor = Colors.TEXT
    val selectedColor = Colors.BLACK
    val density = LocalDensity.current
    val tabWidths = remember {
        val tabWidthStateList = mutableStateListOf<Dp>()

        repeat(items.size) { tabWidthStateList.add(0.dp) }

        tabWidthStateList
    }

    Column {
        TabRow(
            divider = { HorizontalDivider(color = Colors.GREY0) },
            indicator = { positions ->
                val current = positions[indexSelected]
                val tabWidth =  tabWidths[indexSelected]

                Indicatored(
                    currentTabPosition = current,
                    tabWidth = tabWidth,
                    color = selectedColor)
            },
            selectedTabIndex = indexSelected,
            contentColor = unselectedColor,
            containerColor = Colors.WHITE) {

            items.forEachIndexed { index, item ->

                Tabed(
                    text = item,
                    selected = index == indexSelected,
                    unselectedContentColor = unselectedColor,
                    selectedContentColor = selectedColor,
                    rippleColor = Colors.GREYC,
                    onClick = { onChanged(index) },
                    onTextLayout = { layoutResult ->
                        val width = with(density) { layoutResult.size.width.toDp() }

                        tabWidths[indexSelected] = width
                    }
                )
            }
        }
    }
}

@Composable
private fun Indicatored(currentTabPosition: TabPosition, tabWidth: Dp, color: Color){
    val shape = RoundedCornerShape(topStart = radiusIndicator, topEnd = radiusIndicator)
    val modifier = Modifier
        .customTabIndicatorOffset(currentTabPosition = currentTabPosition, tabWidth = tabWidth)
        .clip(shape)

    TabRowDefaults.Indicator(
        modifier = modifier,
        height = heightIndicator,
        color = color
    )
}

@Composable
private fun Tabed(text: String, selected: Boolean, unselectedContentColor: Color,
                  selectedContentColor: Color, rippleColor: Color, onClick: () -> Unit,
                  onTextLayout: (TextLayoutResult) -> Unit = {}){

    val contentColor = if(selected) selectedContentColor else unselectedContentColor

    Tab(
        selected = selected,
        selectedContentColor = rippleColor,
        unselectedContentColor = unselectedContentColor,
        onClick = onClick){

        SpacerTabed()

        Text(
            text = text,
            color = contentColor,
            fontSize = 16.sp,
            fontWeight = if(selected) FontWeight.SemiBold else FontWeight.Normal,
            onTextLayout = onTextLayout
        )

        SpacerTabed()
    }
}

@Composable
private fun SpacerTabed(){
    val modifier = Modifier
        .height(marginIndicator)

    Spacer(modifier = modifier)
}

private fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition,
    tabWidth: Dp
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "customTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val duration = durationIndicatorAnimation
    val easing = easingIndicatorAnimation
    val currentTabWidth by animateDpAsState(
        targetValue = tabWidth,
        animationSpec = tween(durationMillis = duration, easing = easing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = ((currentTabPosition.left + currentTabPosition.right - tabWidth) / 2),
        animationSpec = tween(durationMillis = duration, easing = easing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}