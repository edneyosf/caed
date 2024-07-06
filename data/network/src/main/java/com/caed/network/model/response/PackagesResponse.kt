package com.caed.network.model.response

import com.caed.network.model.BoxInfo
import com.caed.network.model.BoxStatus
import com.caed.network.model.Devolution
import com.caed.network.model.Package
import com.caed.network.model.Receipt
import com.google.gson.annotations.SerializedName

data class PackagesResponse(
    val receipt: Receipt,
    val devolution: Devolution,
    val packages: List<Package>,
    @SerializedName("box_status") val boxStatus: List<BoxStatus>,
    @SerializedName("box_info") val boxInfo: BoxInfo
)