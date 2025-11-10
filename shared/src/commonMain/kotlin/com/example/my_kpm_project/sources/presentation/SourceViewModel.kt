package com.example.my_kpm_project.sources.presentation

import com.example.my_kpm_project.base.BaseViewModel
import com.example.my_kpm_project.base.UIState
import com.example.my_kpm_project.sources.application.Source
import com.example.my_kpm_project.sources.application.SourceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SourceViewModel(private val sourceUseCase: SourceUseCase) : BaseViewModel(){

    private val _sourcesState : MutableStateFlow<UIState<List<Source>>> =
        MutableStateFlow<UIState<List<Source>>>(UIState(isLoading = true))

    val sourcesState: MutableStateFlow<UIState<List<Source>>>
        get() = _sourcesState

    init {
        getSources()
    }

    fun getSources() {
        scope.launch {
            _sourcesState.value = UIState(isLoading = true)
            val fetchedSources = sourceUseCase.getSources()
            _sourcesState.value = UIState(result = fetchedSources, isLoading = false)
        }
    }
}