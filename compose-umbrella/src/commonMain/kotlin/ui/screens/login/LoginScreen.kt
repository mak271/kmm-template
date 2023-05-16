package ui.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import com.involta.diamant.presentation.screens.login.LoginViewModel
import com.involta.diamant.presentation.screens.login.models.LoginAction
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ui.navigation.NavigationTree

@Composable
fun LoginScreen() {
    val rootController = LocalRootController.current
    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state by viewModel.viewStates().observeAsState()
        val action by viewModel.viewActions().observeAsState()

        LoginView(state) {
            viewModel.obtainEvent(it)
        }

        LaunchedEffect(action) {
            when (action) {
                LoginAction.OpenRegistrationScreen -> {
                    rootController.push(NavigationTree.Auth.Register.name)
                    viewModel.completeAction()
                }
                null -> {}
            }
        }
    }
}