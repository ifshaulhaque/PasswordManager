package com.example.passwordmanager.db

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val accountDao: AccountDao
) {
    suspend fun insert(account: Account) {
        withContext(Dispatchers.IO) {
            accountDao.insert(account)
        }
    }

    suspend fun update(account: Account) {
        withContext(Dispatchers.IO) {
            accountDao.update(account)
        }
    }

    suspend fun delete(account: Account) {
        withContext(Dispatchers.IO) {
            accountDao.delete(account)
        }
    }

    suspend fun getAllAccounts(): List<Account> {
        return withContext(Dispatchers.IO) {
            accountDao.getAllAccounts()
        }
    }
}
