package com.caed.pacote.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.network.model.Package
import com.caed.pacote.R
import com.caed.uikit.BackAppBar
import com.caed.uikit.StatusInfo
import com.caed.uikit.TabRowed

@Composable
fun ColumnScope.StatusPackageUI(selected: Package, onBack: () -> Unit){
    BackAppBar(title = selected.code) { onBack() }
    Column(modifier = Modifier
        .weight(1f)
        .verticalScroll(rememberScrollState())) {
        TabRowed(indexSelected = 0, items = listOf(stringResource(id = R.string.tab_item_status),
            stringResource(id = R.string.tab_item_data))) {

        }
        Column(modifier = Modifier.padding(20.dp)) {
            Text(stringResource(id = R.string.label_status_package), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(15.dp))
            Column(modifier = Modifier
                .background(color = colorResource(id = R.color.grey1), shape = RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 20.dp)) {

                selected.receipt?.let {
                    StatusInfo(date = it.date, time = it.time, color = colorResource(id = R.color.received),
                        description = it.message)
                }
                selected.devolution?.let {
                    StatusInfo(date = it.date, time = it.time, color = colorResource(id = R.color.devolution),
                        description = it.message)
                }

                if(selected.receipt == null && selected.devolution == null){
                    Text(stringResource(id = R.string.no_moviment), fontSize = 16.sp)
                }
            }
        }
    }
}