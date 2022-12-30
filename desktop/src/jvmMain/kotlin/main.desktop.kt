import com.involta.textile.core.PlatformSDK
import com.involta.textile.core.platform.PlatformConfiguration
import setup.setupDesktopThemedNavigation
import javax.swing.JFrame
import javax.swing.SwingUtilities

fun main() = SwingUtilities.invokeLater {
    PlatformSDK.init(
        PlatformConfiguration()
    )
    JFrame().setupDesktopThemedNavigation()
}