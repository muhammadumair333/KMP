package com.example.my_kpm_project

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    val scope : CoroutineScope

}