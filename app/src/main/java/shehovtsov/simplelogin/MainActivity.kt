package shehovtsov.simplelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import shehovtsov.simplelogin.ui.theme.SimpleLoginTheme
import shehovtsov.simplelogin.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleLoginTheme {
                LoginScreen()
            }
        }
    }
}

