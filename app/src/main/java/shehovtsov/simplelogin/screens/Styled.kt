package shehovtsov.simplelogin.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.LightBg
import shehovtsov.simplelogin.ui.theme.LightButton
import shehovtsov.simplelogin.ui.theme.TextFieldShape

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
        visualTransformation = if (!isPassword || passwordVisible) VisualTransformation.None
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
