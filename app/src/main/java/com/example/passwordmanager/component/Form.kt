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

    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomTextField(
            value = accountName,
            onValueChange = {
                accountName = it
            },
            placeholder = stringResource(id = R.string.account_name)
        )

        CustomTextField(
            value = userName,
            onValueChange = {
                userName = it
            },
            placeholder = stringResource(id = R.string.user_name)
        )

        CustomTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = stringResource(id = R.string.password)
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray, // Background color
                contentColor = Color.White // Text color
            ),
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                onClick.invoke(accountName, userName, password)
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