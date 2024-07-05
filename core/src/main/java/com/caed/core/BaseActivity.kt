package com.caed.core

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel

abstract class BaseActivity : ComponentActivity() {

    protected abstract val viewModel: ViewModel
}