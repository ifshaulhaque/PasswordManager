package com.example.passwordmanager.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")
data class Account(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var accountName: String,
    var username: String,
    var password: String
)
