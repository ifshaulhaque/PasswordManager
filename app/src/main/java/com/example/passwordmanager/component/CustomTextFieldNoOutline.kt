package com.example.passwordmanager.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.passwordmanager.R

@Composable
fun CustomTextFieldNoOutline(
  value: String,
  placeholder: String,
  isPassword: Boolean = false
) {
  var passwordVisible by remember { mutableStateOf(false) }
  val icon = if (passwordVisible) R.drawable.visibility else R.drawable.visible

  Column {
    Text(text = placeholder)
    Row {
      Text(text = value, fontSize = 20.sp)
      Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
      if (isPassword) {
        IconButton(
          onClick = { passwordVisible = !passwordVisible },
          modifier = Modifier.size(16.dp)
        ) {
          Icon(painter = painterResource(id = icon), contentDescription = "Password Visibility")
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun CustomTextFieldNoOutlinePreview() {
  CustomTextFieldNoOutline(value = "ss", placeholder = "AccountName")
}