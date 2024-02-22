package shehovtsov.simplelogin.screens.authorization


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LifecycleOwner
import shehovtsov.simplelogin.viewModel.AuthorizationViewModel
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.screens.styledElements.AnimatedCard
import shehovtsov.simplelogin.screens.styledElements.FiledButton
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.LightButton

@Composable
fun AuthorizationScreen(
    authorizationViewModel: AuthorizationViewModel? = null,
    owner: LifecycleOwner
) {
    Image(
        painter = painterResource(id = R.drawable.login_screen_bg),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.padding),
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Column {
                FiledButton(
                    text = stringResource(id = R.string.signin),
                    onClick = {
                        authorizationViewModel?.signInVisibility = true
                    }
                )
                FiledButton(
                    text = stringResource(id = R.string.register),
                    textColor = DarkButton,
                    background = LightButton,
                    onClick = {
                        authorizationViewModel?.signUpVisibility = true
                    }
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        if (authorizationViewModel?.signInVisibility == true) {
            AnimatedCard(authorizationViewModel.signInVisibility) {
                Login(authorizationViewModel, owner)
            }
        } else {
            authorizationViewModel?.signUpVisibility?.let {
                AnimatedCard(it) {
                    Registration(authorizationViewModel, owner)
                }
            }
        }
    }
}