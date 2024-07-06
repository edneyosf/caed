package com.caed.pacote

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.caed.core.BaseActivity
import com.caed.domain.Navigator
import com.caed.network.model.Package
import com.caed.pacote.ui.PackageUI
import com.caed.pacote.ui.PackageUIEvent
import com.caed.pacote.ui.PackageUIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class PackageActivity : BaseActivity(), PackageUIEvent {

    private val viewModel: PackageViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreateUI()
    }

    override fun onCreateUI() = setContent {
        val screen = PackageUI(action = this)
        val state = viewModel.state.collectAsState()
        val receipt by remember { viewModel.receipt }
        val devolution by remember { viewModel.devolution }
        val packages by remember { viewModel.packages }
        val boxStatus by remember { viewModel.boxStatus }
        val boxInfo by remember { viewModel.boxInfo }
        val selected by remember { viewModel.selected }

        screen.UI(
            state = state.value,
            receipt = receipt,
            devolution = devolution,
            packages = packages,
            boxStatus = boxStatus,
            boxInfo = boxInfo,
            selected = selected)
    }

    override fun onBackPressed() {
        if(viewModel.state.value is PackageUIState.Info){
            viewModel.setState(PackageUIState.Success)
        }
        else{
            Navigator.toLogin(this)
            super.onBackPressed()
        }
    }

    override fun onDismissAlert() {
        Navigator.toLogin(this)
        finish()
    }

    override fun onShowInfo(item: Package){
        viewModel.setSelected(item)
        viewModel.setState(PackageUIState.Info)
    }

    override fun onBack() {
        Navigator.toLogin(this)
        finish()
    }

    override fun onBackInfo() = viewModel.setState(PackageUIState.Success)
}
