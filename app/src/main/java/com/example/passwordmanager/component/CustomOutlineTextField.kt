package com.example.passwordmanager.component

import com.example.passwordmanager.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomOutlineTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    error: String? = null
) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth(),
            label = { Text(text = placeholder) },
        )

        error?.let {
            Text(
                text = it,
                color = colorResource(id = R.color.red),
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomTextFieldPreview() {
    CustomOutlineTextField(value = "", onValueChange = {}, placeholder = "Name", error = "required")
}