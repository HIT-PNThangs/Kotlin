package com.example.pnt.hit.todolist.util

sealed interface UiEvent {
    object PopBackStack: UiEvent

    data class Navigate(
        val route: String
    ) : UiEvent

    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ) : UiEvent
}