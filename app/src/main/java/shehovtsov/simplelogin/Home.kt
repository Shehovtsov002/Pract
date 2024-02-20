package shehovtsov.simplelogin

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import shehovtsov.simplelogin.screens.HomeScreen
import shehovtsov.simplelogin.ui.theme.LoginTheme

class Home : Screen {
    @Composable
    override fun Content() {
        LoginTheme {
            HomeScreen()
        }
    }
}