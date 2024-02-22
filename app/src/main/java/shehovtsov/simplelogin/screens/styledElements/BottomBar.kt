package shehovtsov.simplelogin.screens.styledElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.ui.theme.LightButton

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