package com.example.passwordmanager.component

import com.example.passwordmanager.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Details(
    accountName: String,
    userName: String,
    password: String,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.account_details),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )

        CustomTextFieldNoOutline(
            value = accountName,
            placeholder = stringResource(id = R.string.account_details)
        )

        CustomTextFieldNoOutline(
            value = userName,
            placeholder = stringResource(id = R.string.user_name)
        )
        
        CustomTextFieldNoOutline(
            value = password,
            placeholder = stringResource(id = R.string.password),
            isPassword = true
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray, // Background color
                    contentColor = Color.White // Text color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                onClick = {
                    onEdit.invoke()
                }
            ) {
                Text(text = stringResource(id = R.string.edit))
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.red), // Background color
                    contentColor = Color.White // Text color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                onClick = {
                    onDelete.invoke()
                }
            ) {
                Text(text = stringResource(id = R.string.delete))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    Details(
        accountName = "Google",
        userName = "xyz@gmail.com",
        password = "989898",
        onEdit = {},
        onDelete = {}
    )
}