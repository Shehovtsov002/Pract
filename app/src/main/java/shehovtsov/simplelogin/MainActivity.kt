package shehovtsov.simplelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.DisposableEffect
import shehovtsov.simplelogin.screens.LoginScreen
import shehovtsov.simplelogin.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                LoginScreen(mainViewModel)
                val backPressedHandler = BackHandler {
                    mainViewModel.resetAuthVisibility()
                }
            }
        }
    }
}

