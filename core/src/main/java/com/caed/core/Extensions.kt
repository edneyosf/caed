package com.caed.core

import android.view.View
import android.view.ViewTreeObserver
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

fun View.whenKeyboardVisible(onVisible: () -> Unit) = ViewTreeObserver.OnGlobalLayoutListener {
    val insets = ViewCompat.getRootWindowInsets(this)
    val ime = WindowInsetsCompat.Type.ime()

    if (insets?.isVisible(ime) == true) { onVisible.invoke() }
}