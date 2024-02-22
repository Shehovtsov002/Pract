package shehovtsov.simplelogin.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import shehovtsov.simplelogin.R
import shehovtsov.simplelogin.screens.styledElements.BottomBar
import shehovtsov.simplelogin.screens.styledElements.FiledButton
import shehovtsov.simplelogin.ui.theme.DarkButton
import shehovtsov.simplelogin.ui.theme.Dimensions
import shehovtsov.simplelogin.ui.theme.LightButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SingleItemScreen(item: Painter, author: String) {
    Scaffold() {
        Column {
            Image(
                modifier = Modifier
                    .fillMaxHeight(.7f)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                painter = item,
                contentDescription = ""
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(.2f),
                    painter = item,
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier.fillMaxSize(.4f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = author, fontSize = Dimensions.buttonText)
                    Text(text = "subscribers count")
                }
                FiledButton(
                    text = "follow",
                    background = DarkButton,
                    textColor = LightButton,
                    onClick = {}
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.fillMaxSize(0.2f)
                ) {
                    Icon(imageVector = Icons.Filled.HeartBroken, null)
                }
                FiledButton(
                    text = stringResource(id = R.string.save),
                    background = DarkButton,
                    textColor = LightButton,
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(.8f)
                )
                IconButton(
                    onClick = { },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(imageVector = Icons.Filled.Share, null)
                }
            }
        }
    }
}
