package com.example.my_kpm_project.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.my_kpm_project.db.DataBaseDriverFactory
import com.example.my_kpm_project.db.MyKpmAppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataBaseModule =  module {
    single<SqlDriver>{ DataBaseDriverFactory(androidContext()).createDriver() }
    single<MyKpmAppDatabase>{ MyKpmAppDatabase(get()) }
}