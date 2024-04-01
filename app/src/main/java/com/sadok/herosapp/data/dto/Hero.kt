package com.sadok.herosapp.data.dto


import com.google.gson.annotations.SerializedName

data class Hero(
    val id: Int,
    val name: String,
    @SerializedName("localized_name")
    val localizedName: String,
    @SerializedName("primary_attr")
    val primaryAttr: String,
    @SerializedName("attack_type")
    val attackType: String,
    val roles: List<String>,
    val legs: Int
)