package com.aaron.fetch.data.remote.models.responses

import com.aaron.fetch.utilities.constants.AppConstants
import com.google.gson.annotations.SerializedName

class HiringResponse : ArrayList<HiringResponseItem>()
data class HiringResponseItem(
    @SerializedName("id")
    val id: Int? = Int.MIN_VALUE,
    @SerializedName("listId")
    val listId: Int? = Int.MIN_VALUE,
    @SerializedName("name")
    val name: String? = AppConstants.EMPTY_STRING
)