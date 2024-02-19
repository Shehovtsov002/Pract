package shehovtsov.simplelogin.screens


import android.widget.Toast
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shehovtsov.simplelogin.MainViewModel
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.GreyText
import shehovtsov.simplelogin.ui.theme.LightBg
import shehovtsov.simplelogin.ui.theme.LightButton
import shehovtsov.simplelogin.ui.theme.TextFieldShape

@Preview(showBackground = true)
@Composable
fun LoginScreen(
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
                SignIn(mainViewModel)
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
fun SignIn(
    mainViewModel: MainViewModel? = null
) {
    val context = LocalContext.current

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
                value = "",
                onChange = {}
            )

            TextPlaceholder(
                text = stringResource(
                    id = R.string.password
                ),
                value = "", onChange = {},
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

@Preview
@Composable
fun Registration(
    mainViewModel: MainViewModel? = null
) {
    val context = LocalContext.current

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
                value = "",
                onChange = {}
            )

            TextPlaceholder(
                text = stringResource(
                    id = R.string.password
                ),
                value = "",
                onChange = {},
                isPassword = true
            )

            FiledButton(
                text = stringResource(id = R.string.register),
                onClick = {

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

@Composable
fun TextPlaceholder(
    text: String,
    value: String,
    onChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.elementPadding)
            .clip(RoundedCornerShape(Dimensions.roundedCornerTextField)),
        value = value,
        onValueChange = onChange,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = TextFieldShape.copy(0f),
            focusedIndicatorColor = TextFieldShape.copy(0f),
            unfocusedContainerColor = TextFieldShape,
            focusedContainerColor = TextFieldShape
        ),
        placeholder = { Text(text) },
        visualTransformation = if (isPassword && passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
        ),
        trailingIcon = {
            if (isPassword) {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, null)
                }
            }
        }
    )
}

@Composable
fun FiledButton(
    text: String,
    textColor: Color = LightButton,
    background: Color = DarkButton,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimensions.elementPadding),
        colors = ButtonDefaults.buttonColors(
            containerColor = background
        ),
        onClick = { onClick() }
    ) {
        Text(
            modifier = Modifier
                .padding(Dimensions.elementPadding),
            text = text,
            color = textColor,
            fontSize = Dimensions.buttonText,
            fontWeight = FontWeight.W500
        )
    }
}

@Composable
fun SocialsButton(
    text: String,
    icon: Painter,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(Dimensions.elementPadding),
        shape = RoundedCornerShape(Dimensions.roundedCornerPercent),
        onClick = { onClick() }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(Dimensions.iconSize),
                painter = icon,
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                modifier = Modifier.padding(Dimensions.elementPadding),
                text = text,
                fontSize = Dimensions.buttonText,
                color = DarkButton
            )
        }
    }
}

@Composable
fun AnimatedAuthCard(
    visibility: Boolean,
    content: @Composable (ColumnScope.() -> Unit)
) {
    val startValue = LocalConfiguration.current.screenHeightDp.toFloat()
    val endValue = 0f
    val duration = 500
    val offsetY = remember { Animatable(startValue) }
    LaunchedEffect(key1 = visibility) {
        if (visibility) {
            offsetY.animateTo(
                targetValue = endValue,
                animationSpec = tween(durationMillis = duration)
            )
        } else {
            offsetY.animateTo(
                targetValue = startValue,
                animationSpec = tween(durationMillis = duration)
            )
        }
    }

    Card(
        modifier = Modifier
            .fillMaxHeight(Dimensions.authCardFraction)
            .fillMaxWidth()
            .offset(y = offsetY.value.dp),
        colors = CardDefaults.cardColors(
            containerColor = LightBg,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimensions.elevation
        ),
        shape = RoundedCornerShape(
            topStartPercent = Dimensions.roundedCornerPercent,
            topEndPercent = Dimensions.roundedCornerPercent
        ),
        content = content
    )
}
