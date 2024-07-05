package com.caed.network.model

sealed class Data<out T> {
    data class Success<out T>(val value: T) : Data<T>()
    data class Error(val cause: Throwable?) : Data<Nothing>()
}