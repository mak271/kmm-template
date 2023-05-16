package com.involta.diamant.presentation.screens.login.models

sealed class LoginEvent {
    data class TextChanged(val text: String) : LoginEvent()
    object ButtonClick : LoginEvent()
}