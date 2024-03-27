package com.example.dostap.auth.data.model

sealed class SignUpResult<T> {
    class VerificationSent<T>: SignUpResult<T>()
    class Unauthorized<T>: SignUpResult<T>()
    class UnknownError<T>: SignUpResult<T>()
    class UserExists<T>: SignUpResult<T>()
}