package com.example.my_kpm_project.base

data class UIState<T>(
    val result: T? = null,
    val isLoading: Boolean = false,
    val error: String? = null)