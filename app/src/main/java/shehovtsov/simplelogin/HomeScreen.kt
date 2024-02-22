package shehovtsov.simplelogin

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import shehovtsov.simplelogin.room.entities.UserData
import shehovtsov.simplelogin.screens.HomeScreen
import shehovtsov.simplelogin.ui.theme.LoginTheme

class HomeScreen(
    private val user: UserData
) : Screen {
    @Composable
    override fun Content() {
        LoginTheme {
            HomeScreen(user)
        }
    }
}