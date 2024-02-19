package shehovtsov.simplelogin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var signInVisibility by mutableStateOf(false)
    var signUpVisibility by mutableStateOf(false)

    fun resetAuthVisibility(){
        signUpVisibility = false
        signInVisibility = false
    }
}