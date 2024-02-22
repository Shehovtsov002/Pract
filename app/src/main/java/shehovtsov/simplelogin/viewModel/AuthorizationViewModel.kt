package shehovtsov.simplelogin.viewModel

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel

class AuthorizationViewModel : ScreenModel {

    var signInVisibility by mutableStateOf(false)
    var signUpVisibility by mutableStateOf(false)

    fun resetAuthVisibility() {
        signUpVisibility = false
        signInVisibility = false
    }
}