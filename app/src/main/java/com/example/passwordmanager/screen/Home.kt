package com.example.passwordmanager.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.passwordmanager.R
import com.example.passwordmanager.component.Details
import com.example.passwordmanager.component.Form
import com.example.passwordmanager.component.PasswordManagerCard
import com.example.passwordmanager.db.Account

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val formSheetState = rememberModalBottomSheetState()
    var showFormBottomSheet by remember { mutableStateOf(false) }
    val detailSheetState = rememberModalBottomSheetState()
    var showDetailBottomSheet by remember { mutableStateOf(false) }

    var account by remember { mutableStateOf<Account?>(null) }
    val addNewAccountButtonText = stringResource(id = R.string.add_new_account)
    val updateButtonText = stringResource(id = R.string.update)
    var formButtonText by remember { mutableStateOf(addNewAccountButtonText) }

    Scaffold(
        floatingActionButton = {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = colorResource(id = R.color.blue_100))
                    .padding(16.dp)
                    .clickable {
                        formButtonText = addNewAccountButtonText
                        showFormBottomSheet = true
                    }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "add",
                    tint = Color.White
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.password_manager))
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().
            padding(
                top = innerPadding.calculateTopPadding() + 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(homeViewModel.allAccounts) { item: Account ->
                PasswordManagerCard(
                    account = item,
                    onClick = {
                        showFormBottomSheet = false
                        account = it
                        showDetailBottomSheet = true
                    }
                )
            }
        }

        account?.let {
            if (showDetailBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showDetailBottomSheet = false},
                    sheetState = detailSheetState
                ) {
                    Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                        Details(
                            accountName = it.accountName,
                            userName = it.username,
                            password = it.password,
                            onEdit = {
                                showDetailBottomSheet = false
                                formButtonText = updateButtonText
                                showFormBottomSheet = true
                            },
                            onDelete = {
                                homeViewModel.delete(it)
                                showDetailBottomSheet = false
                            }
                        )
                    }
                }
            }
        }

        if (showFormBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showFormBottomSheet = false
                },
                sheetState = formSheetState
            ) {
                Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                    Form(
                        accountName = if (formButtonText == updateButtonText) account?.accountName ?: "" else "",
                        userName = if (formButtonText == updateButtonText) account?.username ?: "" else "",
                        password = if (formButtonText == updateButtonText) account?.password ?: "" else "",
                        buttonText = formButtonText
                    ) { accountName, userName, password ->
                        if (formButtonText == addNewAccountButtonText) {
                            homeViewModel.insert(
                                Account(
                                    accountName = accountName,
                                    username = userName,
                                    password = password
                                )
                            )
                        } else {
                            account?.let {
                                it.accountName = accountName
                                it.username = userName
                                it.password = password
                                homeViewModel.update(it)
                            }
                        }

                        showFormBottomSheet = false
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}