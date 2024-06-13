package com.example.passwordmanager.component

import com.example.passwordmanager.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Form(
    accountName: String = "",
    userName: String = "",
    password: String = "",
    buttonText: String,
    onClick: (String, String, String) -> Unit
) {
    var accountName by remember { mutableStateOf(accountName) }
    var userName by remember { mutableStateOf(userName) }
    var password by remember { mutableStateOf(password) }

    var accountNameError by remember { mutableStateOf<String?>(null) }
    var usernameError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    val requiredText = stringResource(id = R.string.required)

    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomOutlineTextField(
            value = accountName,
            onValueChange = {
                if (it.isNotEmpty()) accountNameError = null
                accountName = it
            },
            placeholder = stringResource(id = R.string.account_name),
            error = accountNameError
        )

        CustomOutlineTextField(
            value = userName,
            onValueChange = {
                if (it.isNotEmpty()) usernameError = null
                userName = it
            },
            placeholder = stringResource(id = R.string.user_name),
            error = usernameError
        )

        CustomOutlineTextField(
            value = password,
            onValueChange = {
                if (it.isNotEmpty()) passwordError = null
                password = it
            },
            placeholder = stringResource(id = R.string.password),
            error = passwordError
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray, // Background color
                contentColor = Color.White // Text color
            ),
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                if (accountName.isNotEmpty() && userName.isNotEmpty() && password.isNotEmpty()) {
                    onClick.invoke(accountName, userName, password)
                } else {
                    accountNameError = if (accountName.isEmpty()) requiredText else null
                    usernameError = if (userName.isEmpty()) requiredText else null
                    passwordError = if (password.isEmpty()) requiredText else null
                }
            }
        ) {
            Text(text = buttonText)
        }
    }
}

@Composable
@Preview (showBackground = true)
fun FormPreview() {
    Form(
        buttonText = "Add New Account",
        onClick = { _, _, _ ->

        }
    )
}