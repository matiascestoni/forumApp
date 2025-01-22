package com.test.forumapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.forumapp.presentation.model.LoginUIState
import com.test.forumapp.presentation.viewmodel.LoginViewModel

@Composable
fun LoginScreen(navigateToHome: () -> Unit, viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") })
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") })
        Button(onClick = { viewModel.login(username, password) }) { Text("Login") }

        when (loginState) {
            LoginUIState.Idle -> {}
            is LoginUIState.Loading -> CircularProgressIndicator()
            is LoginUIState.Error -> Text(
                (loginState as LoginUIState.Error).message,
                color = Color.Red
            )

            is LoginUIState.Success -> {
                navigateToHome()
            }

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(navigateToHome = {}, viewModel = LoginViewModel())
}