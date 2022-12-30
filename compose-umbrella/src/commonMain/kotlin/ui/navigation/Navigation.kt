package ui.navigation

import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ui.screens.login.LoginScreen
import ui.screens.register.RegisterScreen
import ui.screens.splash.SplashScreen

fun RootComposeBuilder.generateGraph() {
    screen(NavigationTree.Splash.Splash.name) {
        SplashScreen()
    }
    authFlow()
}

fun RootComposeBuilder.authFlow() {
    flow(NavigationTree.Auth.AuthFlow.name) {
        screen(NavigationTree.Auth.Login.name) {
            LoginScreen()
        }

        screen(NavigationTree.Auth.Register.name) {
            RegisterScreen()
        }
    }
}