package com.caed.pacote.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.caed.core.UI
import com.caed.network.model.BoxInfo
import com.caed.network.model.BoxStatus
import com.caed.network.model.Devolution
import com.caed.network.model.Package
import com.caed.network.model.Receipt
import com.caed.pacote.R
import com.caed.uikit.BackAppBar
import com.caed.core.R as RCore
import com.caed.uikit.BaseUI
import com.caed.uikit.BottomNavigation
import com.caed.uikit.ItemData
import com.caed.uikit.ItemPackage
import com.caed.uikit.MyAlert
import com.caed.uikit.MyLoading
import com.caed.uikit.PackageMetrics
import com.caed.uikit.StatusInfo
import com.caed.uikit.TabRowed

internal class PackageUI(override val action: PackageUIEvent? = null) : UI(action) {

    @Composable
    fun UI(state: PackageUIState? = null, receipt: Receipt? = null, devolution: Devolution? = null,
           packages: List<Package>? = null, boxStatus: List<BoxStatus>? = null, boxInfo: BoxInfo? = null,
           selected: Package? = null) = BaseUI {

        val error = state is PackageUIState.Error
        val loading = state is PackageUIState.Loading
        val tabs = listOf(
            stringResource(id = R.string.tab_item_packages),
            stringResource(id = R.string.tab_item_status),
            stringResource(id = R.string.tab_item_data
        ))
        var tabIndex by remember { mutableIntStateOf(0) }
        var msgError = ""

        if (error) {
            msgError = (state as PackageUIState.Error).message ?: stringResource(id = RCore.string.error_internal)

            MyAlert(stringResource(id = RCore.string.title_alert), msgError){
                action?.onDismissAlert()
            }
        }

        Column {
            if(state is PackageUIState.Info && selected != null){
                StatusPackageUI(selected){ action?.onBackInfo() }
            }
            else{
                BackAppBar(title = stringResource(id = R.string.title_packages)) {
                    action?.onBack()
                }
                if(loading){
                    Loading()
                }
                else{
                    Row(
                        Modifier
                            .horizontalScroll(rememberScrollState())
                            .padding(horizontal = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)) {

                        receipt?.let {
                            PackageMetrics(
                                title = stringResource(id = R.string.title_received_metrics),
                                textA = stringResource(id = R.string.label_received),
                                valueA = it.received.toString(), percentA = it.receivedValue,
                                textB = stringResource(id = R.string.label_missing),
                                valueB = it.missing.toString(), percentB = it.missingValue,
                                color = colorResource(id = R.color.received))
                        }
                        devolution?.let {
                            PackageMetrics(
                                title = stringResource(id = R.string.title_devolution_metrics),
                                textA = stringResource(id = R.string.label_devolution),
                                valueA = it.received.toString(), percentA = it.receivedValue,
                                textB = stringResource(id = R.string.label_missing),
                                valueB = it.missing.toString(), percentB = it.missingValue,
                                color = colorResource(id = R.color.devolution))
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())) {
                        TabRowed(indexSelected = tabIndex, items = tabs) { tabIndex = it  }
                        when(tabIndex){
                            0 -> Packages(packages)
                            1 -> Status(boxStatus)
                            2 -> Data(boxInfo)
                        }
                    }
                }
            }
            BottomNavigation()
        }
    }


    @Composable fun ColumnScope.Loading(){
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            MyLoading()
        }
        Spacer(modifier = Modifier.weight(1f))
    }

    @Composable
    private fun ColumnScope.Packages(packages: List<Package>?){
        Row(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Icon(imageVector = Icons.AutoMirrored.Default.List, contentDescription = "")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = stringResource(id = R.string.label_list_packages),
                fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }

        HorizontalDivider(color = colorResource(id = R.color.div))

        packages?.let {
            LazyColumn(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()) {
                items(packages) { item ->
                    ItemPackage(item.code,
                        received = item.receipt != null,
                        devolution = item.devolution != null){
                        action?.onShowInfo(item)
                    }
                    Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                        HorizontalDivider(color = colorResource(id = R.color.div))
                    }
                }
            }
        }
    }

    @Composable
    private fun Status(boxStatus: List<BoxStatus>?) = boxStatus?.let {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(stringResource(id = R.string.label_status_box), fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(15.dp))
            Column(modifier = Modifier
                .background(color = colorResource(id = R.color.grey1), shape = RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 20.dp)) {

                for (item in it){
                    val color = when(item.id){
                        1 -> colorResource(id = R.color.point_1)
                        2 -> colorResource(id = R.color.point_2)
                        3 -> colorResource(id = R.color.point_3)
                        4 -> colorResource(id = R.color.point_4)
                        else -> colorResource(id = R.color.grey1)
                    }

                    StatusInfo(date = item.date, time = item.time, color = color, description = item.message)
                }
            }
        }
    }

    @Composable
    private fun Data(boxInfo: BoxInfo?) = boxInfo?.let {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Dados da caixa", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(15.dp))
            ItemData(label = stringResource(id = R.string.label_code), text = it.code)
            HorizontalDivider(color = colorResource(id = R.color.div))
            ItemData(label = stringResource(id = R.string.label_point), text = it.point)
            HorizontalDivider(color = colorResource(id = R.color.div))
            ItemData(label = stringResource(id = R.string.label_city), text = it.city)
            HorizontalDivider(color = colorResource(id = R.color.div))
            ItemData(label = stringResource(id = R.string.label_school), text = it.school)
            HorizontalDivider(color = colorResource(id = R.color.div))
            ItemData(label = stringResource(id = R.string.label_year), text = it.year)
            HorizontalDivider(color = colorResource(id = R.color.div))
            ItemData(label = stringResource(id = R.string.label_discipline), text = it.discipline)
            HorizontalDivider(color = colorResource(id = R.color.div))
        }
    }
}

@Preview
@Composable
private fun PackageScreen() = PackageUI().UI()