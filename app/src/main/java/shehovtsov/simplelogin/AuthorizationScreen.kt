package shehovtsov.simplelogin

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import cafe.adriel.voyager.core.model.rememberNavigatorScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import shehovtsov.simplelogin.screens.authorization.AuthorizationScreen
import shehovtsov.simplelogin.ui.theme.LoginTheme
import shehovtsov.simplelogin.viewModel.AuthorizationViewModel

class AuthorizationScreen(
    private val owner: LifecycleOwner
) : Screen {
    override val key: ScreenKey = uniqueScreenKey
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = navigator.rememberNavigatorScreenModel { AuthorizationViewModel() }
        LoginTheme {
            AuthorizationScreen(screenModel, owner)
            BackHandler {
                screenModel.resetAuthVisibility()
            }
        }
    }
}

