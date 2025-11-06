package com.example.my_kpm_project.db

import app.cash.sqldelight.db.SqlDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class DataBaseDriverFactory {

    fun createDriver(): SqlDriver
}