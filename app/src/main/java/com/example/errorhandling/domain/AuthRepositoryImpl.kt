package com.example.errorhandling.domain

import android.net.http.HttpException
import java.io.IOException

/*
class AuthRepositoryImpl:AuthRepository {
    override suspend fun register(password: String): MineResult<User, DataError.NetWork> {
        // API CALL LOGIC
      return try {
            val user = User(email = "test@mail", token = "testToken", fullName = "testName")
          MineResult.Success(user)
        } catch (e: HttpException){
            when(e.cause){
                408 -> MineResult.Error(DataError.NetWork.REQUEST_TIMEOUT)
                413 -> MineResult.Error(DataError.NetWork.PAYLOAD_TOO_LARGE)
                else -> MineResult.Error(DataError.NetWork.UNKNOWN)
            }
        } catch (e: IOException){

        }
    }
}*/
