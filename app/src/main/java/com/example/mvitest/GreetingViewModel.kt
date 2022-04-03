package com.example.mvitest

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GreetingViewModel {
    data class UiState(val name: String)

    private val _uiState = MutableStateFlow(UiState(name = ""))
    val uiState=_uiState.asStateFlow()

    sealed class UiAction{
        class NameChanged(val name:String):UiAction()
    }
    fun handleAction(action:UiAction){
        when(action){
            is UiAction.NameChanged -> {
                _uiState.value= uiState.value.copy(
                    name=action.name
                )
            }
        }
    }
}