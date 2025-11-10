package com.example.my_kpm_project.sources.application

import kotlinx.serialization.Serializable

@Serializable
data class Source (
    val name: String,
    val description: String,
    val language: String,
    val country: String
)

