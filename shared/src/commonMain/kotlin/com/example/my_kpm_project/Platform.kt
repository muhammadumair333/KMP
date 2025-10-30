package com.example.my_kpm_project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform