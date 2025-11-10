package com.example.my_kpm_project.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.example.my_kpm_project.sources.application.Source
import com.example.my_kpm_project.sources.presentation.SourceViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SourceScreen(onUpButtonClicked: () -> Unit,
    sourceViewModel: SourceViewModel = getViewModel()) {
    Column {
        ToolbarSource(onUpButtonClicked)
        ContentView(sourceViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarSource(onUpButtonClicked: () -> Unit){
    TopAppBar(
        title = { Text("Sources") },
        navigationIcon = {
            IconButton(onClick = { onUpButtonClicked() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        }
    )
}


@Composable
fun ContentView(sourceViewModel: SourceViewModel) {
    val sourceState = sourceViewModel.sourcesState.collectAsState()

    SwipeRefresh(
        state = SwipeRefreshState(isRefreshing = sourceState.value.isLoading),
        onRefresh = { sourceViewModel.getSources() }) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val sources = sourceState.value.result ?: emptyList()
            items(sources) { source ->
                SourceItemView(source = source)
            }
        }
    }
}

@Composable
fun SourceItemView(source: Source){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.country + "--" + source.language,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}