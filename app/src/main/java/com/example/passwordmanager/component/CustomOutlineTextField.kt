package com.example.passwordmanager.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
  OutlinedTextField(
      value = value,
      onValueChange = onValueChange,
      modifier = Modifier
          .fillMaxWidth(),
      placeholder = { Text(text = placeholder) },
  )
}

@Preview(showBackground = true)
@Composable
private fun CustomTextFieldPreview() {
    CustomTextField(value = "", onValueChange = {}, placeholder = "Name")
}