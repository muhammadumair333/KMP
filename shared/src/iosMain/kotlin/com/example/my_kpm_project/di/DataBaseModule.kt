package com.example.my_kpm_project.di

import app.cash.sqldelight.db.SqlDriver
import com.example.my_kpm_project.db.DataBaseDriverFactory
import com.example.my_kpm_project.db.MyKpmAppDatabase
import org.koin.dsl.module

val dataBaseModule = module {
    single<SqlDriver> { DataBaseDriverFactory().createDriver() }
    single<MyKpmAppDatabase> { MyKpmAppDatabase(get()) }
}