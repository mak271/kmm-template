package setup

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import ui.navigation.NavigationTree
import ui.navigation.generateGraph
import ui.theme.TextileTheme


fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph() }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()

    setContent {
        TextileTheme {
            val backgroundColor = MaterialTheme.colors.background
            rootController.backgroundColor = backgroundColor

            CompositionLocalProvider(
                LocalRootController provides rootController
            ) {
                ModalNavigator(DefaultModalConfiguration(backgroundColor, DisplayType.EdgeToEdge)) {
                    Navigator(startScreen = NavigationTree.Splash.Splash.name)
                }
            }
        }
    }
}