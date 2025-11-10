package com.example.my_kpm_project.android.screens

import okhttp3.Route

enum class Screen(val route: String) {
    ARTICLES("articles"),
    SOURCE("source"),
    ABOUT("about"),
}