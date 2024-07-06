package com.caed.network.model

import com.google.gson.annotations.SerializedName

data class Devolution(
    val received: Int,
    @SerializedName("received_value") val receivedValue: Float,
    val missing: Int,
    @SerializedName("missing_value") val missingValue: Float
)
