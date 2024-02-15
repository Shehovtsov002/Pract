package shehovtsov.simplelogin.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Вход",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 25.dp)
        )
        Fields()
    }
}

@Composable
fun Fields(){
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var buttonErrorState by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = login,
        onValueChange = { login = it },
        label = { Text("Логин") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        isError = buttonErrorState,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        singleLine = true
    )
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Пароль") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        isError = buttonErrorState,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { buttonErrorState = true }
        ),
        singleLine = true
    )
    Button(onClick = { buttonErrorState = true }) {
        Text("Вход")
    }
}
