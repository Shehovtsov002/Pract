package shehovtsov.simplelogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import shehovtsov.simplelogin.screens.AuthorizationScreen
import shehovtsov.simplelogin.ui.theme.LoginTheme

class AuthorizationActivity : ComponentActivity() {
    private val authorizationViewModel by viewModels<AuthorizationViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginTheme {
                AuthorizationScreen(authorizationViewModel)
                val backPressedHandler = BackHandler {
                    authorizationViewModel.resetAuthVisibility()
                }
            }
        }
    }
}

