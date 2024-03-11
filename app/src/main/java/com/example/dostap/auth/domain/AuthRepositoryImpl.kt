package com.example.dostap.auth.domain

import android.content.SharedPreferences
import android.util.Log
import com.example.dostap.auth.data.model.AuthResult
import com.example.dostap.auth.data.model.SignInRequest
import com.example.dostap.auth.data.model.SignUpRequest
import com.example.dostap.auth.data.repository.AuthApi
import com.example.dostap.auth.data.repository.AuthRepository
import kotlinx.coroutines.delay
import retrofit2.HttpException

class AuthRepositoryImpl(private val authApi: AuthApi, private val prefs: SharedPreferences) : AuthRepository {
    override suspend fun signUp(
        email: String,
        password: String,
        username: String
    ): AuthResult<Unit> {
        return try {
            authApi.signUp(SignUpRequest(
                first_name = username,
                last_name = "placeholder",
                password = password,
                email = email,
                description = "Android test user",
            ))
            AuthResult.VerificationSent()
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
            val response = authApi.signIn(request = SignInRequest(email = email, password = password))
            prefs.edit()
                .putString("jwt", response.Token)
                .apply()
            Log.d("test", "resposne: "+response.Token)
            AuthResult.Authorized()
        } catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
            Log.d("test", "error: " +e.message)
            AuthResult.UnknownError()
        }
    }

    override suspend fun helloworld(): String {
        return try {
            val response = authApi.helloworld().string()
            response
        } catch (e: Exception){
            e.message?:"raha qotaq"
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