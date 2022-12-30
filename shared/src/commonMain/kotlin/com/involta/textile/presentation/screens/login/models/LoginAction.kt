package com.involta.textile.presentation.screens.login.models

sealed class LoginAction {
    object OpenRegistrationScreen : LoginAction()
}