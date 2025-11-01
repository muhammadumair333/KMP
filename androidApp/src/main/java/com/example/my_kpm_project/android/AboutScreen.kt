package com.example.my_kpm_project.android

import android.widget.Toolbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.my_kpm_project.Platform

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(){
    TopAppBar(
        title = { Text("About Device") }
    )
}

@Composable
fun ContentView() {

    val item = makeItems()
    LazyColumn (modifier = Modifier.fillMaxSize()){
        item.forEach { pair ->
            item {
                RowItems(title = pair.first, subTitle = pair.second)
            }
        }
    }
}

@Composable
fun RowItems(title : String, subTitle: String) {
    Column(Modifier.padding(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.bodySmall, color = Color.Black)
        Text(text = subTitle, style = MaterialTheme.typography.bodyLarge, color = Color.DarkGray)
    }
    Divider()
}

private fun makeItems() : List<Pair<String,String>>{
    val platform = Platform()
    platform.logSystemInfo()
    return listOf(
        Pair("Operating System", platform.osName),
        Pair("OS Version", platform.osVersion),
        Pair("Device Model", platform.deviceModel),
        Pair("Screen Density", platform.density.toString())
    )

}