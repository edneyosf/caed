package com.caed.login

import android.os.Bundle
import androidx.activity.compose.setContent
import com.caed.core.BaseActivity
import com.caed.login.ui.LoginUIEvent
import com.caed.login.ui.LoginUI
import com.caed.login.ui.LoginUIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity(), LoginUIEvent {

    override val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LoginUI(action = this)
                .Content(viewModel.state.value)
        }
    }

    override fun onSubmit(userName: String, password: String) {
        if(userName.isNotBlank() && password.isNotBlank()){
            viewModel.login(userName, password)
        }
        else{
            val message = getString(R.string.error_blank_fields)

            viewModel.setState(LoginUIState.Error(message))
        }
    }

    override fun onDismissAlert() = viewModel.setState(LoginUIState.Default)
}
