package com.example.my_kpm_project.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

actual open class BaseViewModel : ViewModel() {

    actual val scope = viewModelScope
}