package shehovtsov.simplelogin.screens

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.graphics.drawable.shapes.Shape
import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.LightButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
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
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.ic_launcher_foreground),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.ic_launcher_foreground),
        painterResource(id = R.drawable.login_screen_bg),
        painterResource(id = R.drawable.login_screen_bg),
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
                    Photo(painter = photo)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun Photo(painter: Painter) {
    Image(
        contentScale = ContentScale.Crop,
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .padding(Dimensions.elementPadding)
            .clip(RoundedCornerShape(Dimensions.roundedCornerPercent))
            .fillMaxWidth()
            .wrapContentHeight()
    )
}

@Composable
fun BottomBar() {
    BottomAppBar(
        containerColor = Color.Black
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = stringResource(id = R.string.home),
                    tint = Color.Cyan
                )
            },
            label = {
                Text(
                    stringResource(id = R.string.home),
                    color = LightButton
                )
            },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.search),
                    tint = Color.Cyan
                )
            },
            label = {
                Text(
                    stringResource(id = R.string.search),
                    color = LightButton
                )
            },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.create),
                    tint = Color.Cyan
                )
            },
            label = {
                Text(
                    stringResource(id = R.string.create),
                    color = LightButton
                )
            },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Mail,
                    contentDescription = stringResource(id = R.string.mail),
                    tint = Color.Cyan
                )
            },
            label = {
                Text(
                    stringResource(id = R.string.mail),
                    color = LightButton
                )
            },
            selected = false,
            onClick = { }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = stringResource(id = R.string.account),
                    tint = Color.Cyan
                )
            },
            label = {
                Text(
                    stringResource(id = R.string.account),
                    color = LightButton
                )
            },
            selected = false,
            onClick = { }
        )
    }
}