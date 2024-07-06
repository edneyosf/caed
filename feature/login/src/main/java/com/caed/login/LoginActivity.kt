package com.caed.login

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.lifecycleScope
import com.caed.core.BaseActivity
import com.caed.domain.Navigator
import com.caed.login.ui.LoginUIEvent
import com.caed.login.ui.LoginUI
import com.caed.login.ui.LoginUIState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity(), LoginUIEvent {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        onCreateUI()
        collectors()
    }

    override fun onCreateUI() = setContent {
        val screen = LoginUI(action = this)
        val state = viewModel.state.collectAsState()

        screen.UI(state.value)
    }

    private fun collectors() = lifecycleScope.launch {
        viewModel.state.collectLatest {
            if(it is LoginUIState.Success){
                Navigator.toPackage(this@LoginActivity)
                finish()
            }
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

    companion object{

    }
}
