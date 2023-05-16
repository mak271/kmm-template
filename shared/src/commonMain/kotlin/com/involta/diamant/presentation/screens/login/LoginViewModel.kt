package com.involta.diamant.presentation.screens.login

import com.involta.diamant.core.BaseViewModel
import com.involta.diamant.presentation.screens.login.models.LoginAction
import com.involta.diamant.presentation.screens.login.models.LoginEvent
import com.involta.diamant.presentation.screens.login.models.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>(
    LoginViewState("")
) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            LoginEvent.ButtonClick -> openRegistrationScreen()
            is LoginEvent.TextChanged -> onTextChanged(viewEvent.text)
        }
    }

    private fun onTextChanged(text: String) {
        viewState = viewState.copy(
            text = text
        )
    }

    private fun openRegistrationScreen() {
        viewAction = LoginAction.OpenRegistrationScreen
    }
}