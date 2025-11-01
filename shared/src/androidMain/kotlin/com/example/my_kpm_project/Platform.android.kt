package com.example.my_kpm_project

import android.content.res.Resources
import android.util.Log

actual class Platform {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = android.os.Build.VERSION.SDK_INT.toString()
    actual val deviceModel: String
    get() = android.os.Build.MODEL ?: "Unknown"
    actual val density: Int
        get()= Resources.getSystem().displayMetrics.density.toInt()

    actual fun logSystemInfo() {
        Log.d("OS_NAME",osName)
        Log.d("OS Version" , osVersion)
        Log.d("Device Model:", deviceModel)
        Log.d("Density:", density.toString())
    }}