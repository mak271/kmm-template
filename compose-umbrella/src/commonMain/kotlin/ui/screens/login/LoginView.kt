package ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.involta.diamant.presentation.screens.login.models.LoginEvent
import com.involta.diamant.presentation.screens.login.models.LoginViewState

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login Now",
                style = MaterialTheme.typography.displayLarge
            )

            TextField(state.text, {
                eventHandler(LoginEvent.TextChanged(it))
            })
            Button({ eventHandler(LoginEvent.ButtonClick) }) {
                Text("Click!")
            }
        }
    }

}