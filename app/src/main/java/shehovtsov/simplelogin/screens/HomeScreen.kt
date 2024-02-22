package shehovtsov.simplelogin.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import shehovtsov.simplelogin.DetailsScreen
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.room.entities.UserData
import shehovtsov.simplelogin.screens.styledElements.BottomBar
import shehovtsov.simplelogin.ui.theme.Dimensions

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    user: UserData
) {
    val context = LocalContext.current
    Toast.makeText(context, "Hi, ${user.login}!", Toast.LENGTH_SHORT).show()
    Image(
        painter = painterResource(id = R.drawable.login_screen_bg),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .alpha(Dimensions.backgroundOpacity),
        contentScale = ContentScale.FillBounds
    )

    val photos = listOf<Painter>(
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.kandinsky),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.ic_launcher_foreground),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.kandinsky),
        painterResource(id = R.drawable.ic_launcher_foreground),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.kandinsky),
        painterResource(id = R.drawable.login_screen_bg),
    )
    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = { BottomBar() }
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(Dimensions.columnCount),
            content = {
                items(photos) { photo ->
                    Photo(painter = photo, "author")
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun Photo(painter: Painter, author: String) {
    val navigator = LocalNavigator.currentOrThrow
    Image(
        contentScale = ContentScale.Crop,
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .padding(Dimensions.elementPadding)
            .clip(RoundedCornerShape(Dimensions.roundedCornerPercent))
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                navigator.push(DetailsScreen(painter, author))
            }
    )
}