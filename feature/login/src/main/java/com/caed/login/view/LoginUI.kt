package com.caed.login.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.caed.core.BaseUI
import com.caed.login.R
import com.caed.uikit.Banner
import com.caed.uikit.BaseUI
import com.caed.uikit.MyButton
import com.caed.uikit.MyTextField

internal class LoginUI(override val action: LoginEvent? = null) : BaseUI(action) {

    @Composable
    fun Content() = BaseUI {
        val userName = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        Column {
            Banner()
            Spacer(modifier = Modifier.weight(2f))
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                UserName(state = userName)
                Spacer(modifier = Modifier.height(30.dp))
                Password(state = password)
            }
            Spacer(modifier = Modifier.weight(1f))
            Submit { action?.onSubmit(userName = userName.value, password = password.value) }
        }
    }

    @Composable
    private fun UserName(state: MutableState<String>){
        val label = stringResource(id = R.string.label_username)
        var value by remember { state }

        MyTextField(value = value, label = label){ value = it }
    }

    @Composable
    private fun Password(state: MutableState<String>){
        val label = stringResource(id = R.string.label_password)
        var value by remember { state }

        MyTextField(value = value, label = label){ value = it }
    }

    @Composable
    private fun Submit(onClick: () -> Unit){
        val value = stringResource(id = R.string.submit_button)

        MyButton(value = value, onClick = onClick)
    }
}

@Preview
@Composable
private fun LoginScreen() = LoginUI().Content()