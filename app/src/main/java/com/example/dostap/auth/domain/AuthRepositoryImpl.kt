package com.example.dostap.auth.domain

import android.content.SharedPreferences
import android.util.Log
import com.example.dostap.auth.data.model.LoginResult
import com.example.dostap.auth.data.model.SignInRequest
import com.example.dostap.auth.data.model.SignUpRequest
import com.example.dostap.auth.data.model.SignUpResult
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
    ): SignUpResult<Unit> {
        return try {
            authApi.signUp(SignUpRequest(
                first_name = username,
                last_name = lastname,
                password = password,
                email = email,
                description = "Android test user",
            ))
            SignUpResult.VerificationSent()
        } catch (e: HttpException){
            if(e.code() == 401){
                SignUpResult.Unauthorized()
            } else if(e.code() == 400){
                val errorBody = e.response()?.errorBody()?.string()
                val errorMessage = JSONObject(errorBody).getString("Message")
                if (errorMessage.contains("user with this email already exists")){
                    SignUpResult.UserExists()
                } else {
                    SignUpResult.UnknownError()
                }
            } else {
                SignUpResult.UnknownError()
            }
        } catch (e: Exception){
            SignUpResult.UnknownError()
        }
    }



    override suspend fun signIn(
        email: String,
        password: String
    ): LoginResult<Unit> {
        return try {
            val response = authApi.signIn(request = SignInRequest(email = email, password = password))
            prefs.edit()
                .putString("jwt", response.Token)
                .apply()
            LoginResult.Authorized()
        } catch (e: HttpException){
            if(e.code() == 401){
                LoginResult.Unauthorized()
            } else if(e.code() == 400){
                val errorBody = e.response()?.errorBody()?.string()
                val errorMessage = JSONObject(errorBody).getString("Message")
                if (errorMessage.contains("no user exist with this email")){
                    LoginResult.UserDoesNotExist()
                } else if(errorMessage.contains("given password of ")) {
                    LoginResult.WrongPassword()
                } else {
                    LoginResult.UnknownError()
                }
            }
            else {
                LoginResult.UnknownError()
            }
        } catch (e: Exception){
            LoginResult.UnknownError()
        }
    }

    override suspend fun deleteAccount(token: String) {
        try {
            val res = authApi.deleteAccount()
        } catch (e: Exception){
            Log.d("test", "delete error:"+e.message)
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

    override suspend fun authenticate(): LoginResult<Unit> {
        return try {
            val token = prefs.getString("jwt", null)?: return LoginResult.Unauthorized()
            //authApi.authenticate("Bearer $token")
            LoginResult.Authorized()
        } catch (e: HttpException){
            if(e.code() == 401){
                LoginResult.Unauthorized()
            } else {
                LoginResult.UnknownError()
            }
        } catch (e: Exception){
            LoginResult.UnknownError()
        }
    }


}