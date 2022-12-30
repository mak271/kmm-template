package setup

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.awt.ComposePanel
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import ui.navigation.NavigationTree
import ui.navigation.generateGraph
import ui.theme.TextileTheme
import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.WindowConstants

fun JFrame.setupDesktopThemedNavigation() {
    val rootController = RootComposeBuilder().apply {
        generateGraph()
    }.build()

    defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    title = "Textile"

    val composePanel = ComposePanel()
    composePanel.setContent {
        CompositionLocalProvider(
            LocalRootController provides rootController
        ) {
            TextileTheme {
                rootController.backgroundColor = MaterialTheme.colors.background

                ModalNavigator(
                    DefaultModalConfiguration(
                        MaterialTheme.colors.background,
                        DisplayType.FullScreen
                    )
                ) {
                    Navigator(NavigationTree.Splash.Splash.name)
                }
            }
        }
    }
    contentPane.add(composePanel, BorderLayout.CENTER)
    setSize(800, 600)
    setLocationRelativeTo(null)
    isVisible = true
}