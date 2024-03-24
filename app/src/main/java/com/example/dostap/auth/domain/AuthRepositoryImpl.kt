package com.example.dostap.auth.domain

import android.content.SharedPreferences
import com.example.dostap.auth.data.model.AuthResult
import com.example.dostap.auth.data.model.SignInRequest
import com.example.dostap.auth.data.model.SignUpRequest
import com.example.dostap.auth.data.repository.AuthApi
import com.example.dostap.auth.data.repository.AuthRepository
import org.json.JSONObject
import retrofit2.HttpException

class AuthRepositoryImpl(private val authApi: AuthApi, private val prefs: SharedPreferences) : AuthRepository {
    override suspend fun signUp(
        email: String,
        password: String,
        username: String,
        lastname: String
    ): AuthResult<Unit> {
        return try {
            authApi.signUp(SignUpRequest(
                first_name = username,
                last_name = lastname,
                password = password,
                email = email,
                description = "Android test user",
            ))
            AuthResult.VerificationSent()
        } catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            } else if(e.code() == 400){
                val errorBody = e.response()?.errorBody()?.string()
                val errorMessage = JSONObject(errorBody).getString("Message")
                if (errorMessage.contains("user with this email already exists")){
                    AuthResult.UserExists()
                } else {
                    AuthResult.UnknownError()
                }
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
            AuthResult.Authorized()
        } catch (e: HttpException){
            if(e.code() == 401){
                AuthResult.Unauthorized()
            } else if(e.code() == 400){
                val errorBody = e.response()?.errorBody()?.string()
                val errorMessage = JSONObject(errorBody).getString("Message")
                if (errorMessage.contains("no user exist with this email")){
                    AuthResult.UserDoesNotExist()
                } else if(errorMessage.contains("given password of ")) {
                    AuthResult.WrongPassword()
                } else {
                    AuthResult.UnknownError()
                }
            }
            else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception){
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



}