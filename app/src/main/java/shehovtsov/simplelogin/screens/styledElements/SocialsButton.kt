package shehovtsov.simplelogin.screens.styledElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions

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

