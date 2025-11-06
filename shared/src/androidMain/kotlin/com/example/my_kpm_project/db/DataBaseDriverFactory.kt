package com.example.my_kpm_project.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DataBaseDriverFactory(private val context: android.content.Context) {

    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
            schema = MyKpmAppDatabase.Schema,
            context = context,
            name = "mykpmapp.db"
        )

}