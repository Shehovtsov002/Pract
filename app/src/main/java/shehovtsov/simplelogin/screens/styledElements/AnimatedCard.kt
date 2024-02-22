package shehovtsov.simplelogin.screens.styledElements

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.LightBg

@Composable
fun AnimatedCard(
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

