package shehovtsov.simplelogin.screens


import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import shehovtsov.simplelogin.MainViewModel
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.GreyText
import shehovtsov.simplelogin.ui.theme.LightButton

@Preview(showBackground = true)
@Composable
fun AuthorizationScreen(
    mainViewModel: MainViewModel? = null
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
                        mainViewModel?.signInVisibility = true
                    }
                )
                FiledButton(
                    text = stringResource(id = R.string.register),
                    textColor = DarkButton,
                    background = LightButton,
                    onClick = {
                        mainViewModel?.signUpVisibility = true
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
        if (mainViewModel?.signInVisibility == true) {
            AnimatedAuthCard(mainViewModel.signInVisibility) {
                Login(mainViewModel)
            }
        } else {
            mainViewModel?.signUpVisibility?.let {
                AnimatedAuthCard(it) {
                    Registration(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Login(
    mainViewModel: MainViewModel? = null
) {
    val context = LocalContext.current

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
                    // TODO: to BD
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
                        mainViewModel?.signInVisibility = false
                        mainViewModel?.signUpVisibility = true
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

@Composable
fun Registration(
    mainViewModel: MainViewModel? = null
) {
    val context = LocalContext.current

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
                text = stringResource(id = R.string.register),
                onClick = {
                    // TODO: add to BD
                }
            )

            TextButton(
                onClick = {
                    mainViewModel?.signInVisibility = true
                    mainViewModel?.signUpVisibility = false
                }
            ) {
                Text(
                    text = stringResource(id = R.string.hasaccount),
                    color = DarkButton,
                    fontSize = Dimensions.standartText
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
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
        }
    }
}
