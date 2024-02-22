package shehovtsov.simplelogin.screens.authorization

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import shehovtsov.simplelogin.HomeScreen
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.screens.styledElements.FiledButton
import shehovtsov.simplelogin.screens.styledElements.SocialsButton
import shehovtsov.simplelogin.screens.styledElements.TextPlaceholder
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.GreyText
import shehovtsov.simplelogin.viewModel.AuthorizationViewModel
import shehovtsov.simplelogin.viewModel.LoginViewModel

@Composable
fun Login(
    authorizationViewModel: AuthorizationViewModel? = null,
    owner: LifecycleOwner
) {
    val context = LocalContext.current
    val loginViewModel = viewModel<LoginViewModel>()
    val navigator = LocalNavigator.currentOrThrow

    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimensions.padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextPlaceholder(
                text = stringResource(
                    id = R.string.login
                ),
                value = login,
                onChange = {
                    login = it
                }
            )

            TextPlaceholder(
                text = stringResource(
                    id = R.string.password
                ),
                value = password,
                onChange = {
                    password = it
                },
                isPassword = true
            )
            FiledButton(
                text = stringResource(id = R.string.signin),
                onClick = {
                    if (login.isNotEmpty() && password.isNotEmpty())
                        loginViewModel.logIn(login, password).observe(owner) { value ->
                            if (value == null) {
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                            } else {
                                navigator.push(HomeScreen(value))
                            }
                        }
                }
            )

            TextButton(
                onClick = {
                    Toast.makeText(context, "forgotpass", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.forgotpass),
                    color = DarkButton,
                    fontSize = Dimensions.standartText
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialsButton(
                    text = stringResource(id = R.string.signin),
                    icon = painterResource(id = R.drawable.google),
                    onClick = {
                        Toast.makeText(context, "google", Toast.LENGTH_SHORT).show()
                    }
                )
                SocialsButton(
                    text = stringResource(id = R.string.signin),
                    icon = painterResource(id = R.drawable.facebook),
                    onClick = {
                        Toast.makeText(context, "facebook", Toast.LENGTH_SHORT).show()
                    }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.noaccount),
                    fontSize = Dimensions.buttonText,
                    color = GreyText
                )
                TextButton(
                    onClick = {
                        authorizationViewModel?.signInVisibility = false
                        authorizationViewModel?.signUpVisibility = true
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.register),
                        color = DarkButton,
                        fontSize = Dimensions.buttonText
                    )
                }
            }
        }
    }
}
