package com.example.dostap.auth.data.model

sealed class AuthResult<T>(val data: T? = null) {
    class Authorized<T>(data: T? = null): AuthResult<T>(data)
    class VerificationSent<T>: AuthResult<T>()
    class Unauthorized<T>: AuthResult<T>()
    class UnknownError<T>: AuthResult<T>()
    class WrongPassword<T>: AuthResult<T>()
    class UserDoesNotExist<T>: AuthResult<T>()
    class UserExists<T>: AuthResult<T>()

}