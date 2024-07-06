package com.caed.domain

import android.content.Context
import android.content.Intent

object Navigator {

    private const val LOGIN_ACTIVITY = "com.caed.login.LoginActivity"
    private const val PACKAGE_ACTIVITY = "com.caed.pacote.PackageActivity"

    fun toLogin(context: Context) = navigate(context, LOGIN_ACTIVITY)
    fun toPackage(context: Context) = navigate(context, PACKAGE_ACTIVITY)

    private fun navigate(context: Context, className: String) = context.run {
        val intent = Intent()

        intent.setClassName(this, className)

        startActivity(intent)
    }
}