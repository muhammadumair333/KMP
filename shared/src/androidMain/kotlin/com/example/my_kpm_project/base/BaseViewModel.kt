package com.example.my_kpm_project.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual open class BaseViewModel : ViewModel() {

    actual val scope = viewModelScope
}