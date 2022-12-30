package ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.involta.textile.presentation.screens.login.models.LoginEvent
import com.involta.textile.presentation.screens.login.models.LoginViewState

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login Now")
        TextField(state.text, {
            eventHandler(LoginEvent.TextChanged(it))
        })
        Button({ eventHandler(LoginEvent.ButtonClick) }) {
            Text("Click!")
        }
    }
}