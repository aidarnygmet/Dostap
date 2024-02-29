package com.example.dostapp.auth

import android.content.Context
import com.google.android.gms.auth.api.identity.SignInClient

class GoogleSignInClient(
    private val context: Context,
    private val oneTapClient: SignInClient
) {

}