package com.example.dostapp.auth.domain

import android.content.SharedPreferences
import com.example.dostapp.auth.data.model.AuthResult
import com.example.dostapp.auth.data.repository.AuthApi
import com.example.dostapp.auth.data.repository.AuthRepository
import kotlinx.coroutines.delay
import retrofit2.HttpException

class AuthRepositoryImpl(private val authApi: AuthApi, private val prefs: SharedPreferences) : AuthRepository {
    override suspend fun signUp(
        email: String,
        password: String,
        username: String
    ): AuthResult<Unit> {
        return try {
//            authApi.signUp(request = SignUpRequest(email = email,
//                username = username,
//                password = password))
            signIn(email = email, password = password)
        } catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun signIn(email: String, password: String): AuthResult<Unit> {
        return try {
            //val response = authApi.signIn(request = AuthRequest(username = email, password = password))
            prefs.edit()
                .putString("jwt", "228")
                .apply()
            delay(2500)
            AuthResult.Authorized()
        } catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
            AuthResult.UnknownError()
        }
    }

    override suspend fun authenticate(): AuthResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null)?: return AuthResult.Unauthorized()
            //authApi.authenticate("Bearer $token")
            delay(2500)
            AuthResult.Authorized()
        } catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
            AuthResult.UnknownError()
        }
    }


}