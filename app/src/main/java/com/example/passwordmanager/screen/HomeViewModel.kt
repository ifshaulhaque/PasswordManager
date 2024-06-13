package com.example.passwordmanager.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwordmanager.db.Account
import com.example.passwordmanager.db.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AccountRepository
): ViewModel() {
    val allAccounts = mutableStateListOf<Account>()

    init {
        fetchAllAccounts()
    }

    private fun fetchAllAccounts() {
        viewModelScope.launch {
            allAccounts.clear()
            allAccounts.addAll(repository.getAllAccounts())
        }
    }

    fun insert(account: Account) {
        viewModelScope.launch {
            repository.insert(account)
            fetchAllAccounts()
        }
    }

    fun update(account: Account) {
        viewModelScope.launch {
            repository.update(account)
            fetchAllAccounts()
        }
    }

    fun delete(account: Account) {
        viewModelScope.launch {
            repository.delete(account)
            fetchAllAccounts()
        }
    }
}