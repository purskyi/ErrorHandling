package com.example.errorhandling.domain

import android.provider.ContactsContract.CommonDataKinds.Email

interface AuthRepository {
    suspend fun register(password: String): MineResult<User, DataError.NetWork>
}

data class User(
    val fullName: String,
    val token: String,
    val email: String
)