package com.caed.core

import androidx.activity.ComponentActivity

abstract class BaseActivity : ComponentActivity(){

    protected abstract fun onCreateUI()
}