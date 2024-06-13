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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Form(
    buttonText: String,
    onClick: (String, String, String) -> Unit
) {
    val accountName by remember { mutableStateOf("") }
    val userName by remember { mutableStateOf("") }
    val password by remember { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomTextField(
            value = accountName,
            onValueChange = {},
            placeholder = stringResource(id = R.string.account_name)
        )

        CustomTextField(
            value = accountName,
            onValueChange = {},
            placeholder = stringResource(id = R.string.user_name)
        )

        CustomTextField(
            value = accountName,
            onValueChange = {},
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