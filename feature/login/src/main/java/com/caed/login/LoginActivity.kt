package com.caed.login

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.caed.login.view.LoginEvent
import com.caed.login.view.LoginUI
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity(), LoginEvent {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { LoginUI(action = this).Content() }
    }

    override fun onSubmit(userName: String, password: String) {
        Log.i("LoginActivity", "onSubmit: "+userName+" - "+password)
    }
}
