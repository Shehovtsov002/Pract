package shehovtsov.simplelogin

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import cafe.adriel.voyager.core.screen.Screen
import shehovtsov.simplelogin.screens.SingleItemScreen

class DetailsScreen(
    private val item: Painter,
    private val author: String
) : Screen {
    @Composable
    override fun Content() {
        SingleItemScreen(item, author)
    }
}