package com.caed.pacote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caed.domain.usecase.GetPackagesUseCase
import com.caed.network.model.BoxInfo
import com.caed.network.model.BoxStatus
import com.caed.network.model.Data
import com.caed.network.model.Devolution
import com.caed.network.model.Package
import com.caed.network.model.Receipt
import com.caed.pacote.ui.PackageUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class PackageViewModel(private val getPackagesUseCase: GetPackagesUseCase) : ViewModel() {

    private val _state = MutableStateFlow<PackageUIState>(PackageUIState.Loading)
    val state = _state.asStateFlow()

    private val _receipt = mutableStateOf<Receipt?>(null)
    val receipt: State<Receipt?> = _receipt

    private val _devolution = mutableStateOf<Devolution?>(null)
    val devolution = _devolution

    private val _packages = mutableStateOf<List<Package>?>(null)
    val packages = _packages

    private val _boxStatus = mutableStateOf<List<BoxStatus>?>(null)
    val boxStatus = _boxStatus

    private val _boxInfo = mutableStateOf<BoxInfo?>(null)
    val boxInfo = _boxInfo

    private val _selected = mutableStateOf<Package?>(null)
    val selected = _selected

    init { getAllPackages() }

    private fun getAllPackages() = viewModelScope.launch {
        when(val data = getPackagesUseCase()){
            is Data.Success -> {
                data.value.run {
                    _receipt.value = receipt
                    _devolution.value = devolution
                    _packages.value = packages
                    _boxStatus.value = boxStatus
                    _boxInfo.value = boxInfo
                }
                _state.value = PackageUIState.Success
            }
            is Data.Error -> {
                val message = data.cause?.message

                _state.value = PackageUIState.Error(message)
            }
        }
    }

    fun setSelected(selected: Package){
        _selected.value = selected
    }

    fun setState(newState: PackageUIState){
        _state.value = newState
    }
}