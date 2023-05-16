package setup

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import ui.navigation.generateGraph
import ui.theme.DiamantTheme
import ui.util.clearAnyFocusOnTap


fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { generateGraph() }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()
    setContent {
        DiamantTheme {
            val configuration = OdysseyConfiguration(
                canvas = this,
                backgroundColor = MaterialTheme.colorScheme.background,
                displayType = DisplayType.FullScreen,
                statusBarColor = MaterialTheme.colorScheme.primaryContainer.toArgb(),
                navigationBarColor = MaterialTheme.colorScheme.surface.toArgb()
            )

            Box(Modifier.fillMaxSize().clearAnyFocusOnTap()) {
                setNavigationContent(configuration, {
                    finishAndRemoveTask()
                }) {
                    generateGraph()
                }
            }
        }
    }
}