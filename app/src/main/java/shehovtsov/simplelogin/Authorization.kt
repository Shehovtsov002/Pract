package shehovtsov.simplelogin

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import shehovtsov.simplelogin.screens.AuthorizationScreen
import shehovtsov.simplelogin.ui.theme.LoginTheme

class Authorization : Screen {
    override val key: ScreenKey = uniqueScreenKey
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = rememberScreenModel { AuthorizationViewModel() }
        LoginTheme {
            AuthorizationScreen(screenModel)
            val backPressedHandler = BackHandler {
                screenModel.resetAuthVisibility()
            }
        }
    }
}

