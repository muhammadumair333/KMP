package com.example.my_kpm_project.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RawSource (
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("language")
    val language: String,
    @SerialName("country")
    val country: String
)