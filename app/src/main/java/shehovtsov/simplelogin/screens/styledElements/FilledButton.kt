package shehovtsov.simplelogin.screens.styledElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.LightButton

@Composable
fun FiledButton(
    text: String,
    textColor: Color = LightButton,
    background: Color = DarkButton,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(Dimensions.elementPadding)
) {
    Button(
        modifier = modifier,
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

