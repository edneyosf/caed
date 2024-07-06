package com.caed.network.model

data class Package(
    val code: String,
    val receipt: PackageDetail?,
    val devolution: PackageDetail?
)