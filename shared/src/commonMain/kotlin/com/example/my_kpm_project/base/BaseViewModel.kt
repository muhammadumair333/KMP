package com.example.my_kpm_project.base

import kotlinx.coroutines.CoroutineScope

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect open class BaseViewModel() {

    val scope : CoroutineScope

}