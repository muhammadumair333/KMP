package com.example.my_kpm_project.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual open class BaseViewModel {
    actual val scope : CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun onCleared() {
        scope.cancel()
    }
}