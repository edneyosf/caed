package com.caed.login.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caed.core.UI
import com.caed.core.whenKeyboardVisible
import com.caed.login.R
import com.caed.core.R as RCore
import com.caed.uikit.Banner
import com.caed.uikit.BaseUI
import com.caed.uikit.MyAlert
import com.caed.uikit.MyButton
import com.caed.uikit.MyLoading
import com.caed.uikit.MyTextField
import kotlinx.coroutines.launch

internal class LoginUI(override val action: LoginUIEvent? = null) : UI(action) {

    @Composable
    fun UI(state: LoginUIState? = null) = BaseUI {
        val scrollState = rememberScrollState()
        val userName = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val view = LocalView.current
        val scope = rememberCoroutineScope()
        val error = state is LoginUIState.Error
        val loading = state is LoginUIState.Loading
        var msgError = ""

        if (error) {
           msgError = (state as LoginUIState.Error).message ?: stringResource(id = RCore.string.error_internal)

            MyAlert(stringResource(id = RCore.string.title_alert), msgError){
                action?.onDismissAlert()
            }
        }

        DisposableEffect(view) {
            val listener = view.whenKeyboardVisible {
                scope.launch { scrollState.animateScrollTo(scrollState.maxValue) }
            }
            view.viewTreeObserver.run {
                addOnGlobalLayoutListener(listener)
                onDispose { removeOnGlobalLayoutListener(listener) }
            }
        }

        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Banner()
            Spacer(modifier = Modifier.weight(2f))
            Spacer(modifier = Modifier.height(30.dp))
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                UserName(state = userName, enabled = !loading)
                Spacer(modifier = Modifier.height(30.dp))
                Password(state = password, enabled = !loading)
            }
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(30.dp))

            if(loading) Loading()
            else{
                Submit {
                    action?.onSubmit(userName = userName.value, password = password.value)
                }
            }
        }
    }

    @Composable
    private fun UserName(enabled: Boolean, state: MutableState<String>){
        val label = stringResource(id = R.string.label_username)
        var value by remember { state }

        MyTextField(value = value, label = label, enabled = enabled){ value = it }
    }

    @Composable
    private fun Password(enabled: Boolean, state: MutableState<String>){
        val label = stringResource(id = R.string.label_password)
        var value by remember { state }

        MyTextField(value = value, label = label, enabled = enabled){ value = it }
    }

    @Composable fun Loading() = Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {

        MyLoading()
        Spacer(modifier = Modifier.height(15.dp))
    }

    @Composable
    private fun Submit(onClick: () -> Unit){
        val value = stringResource(id = R.string.submit_button)

        MyButton(value = value, onClick = onClick)
    }
}

@Preview
@Composable
private fun LoginScreen() = LoginUI().UI()