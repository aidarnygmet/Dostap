package com.example.dostap.auth.presentation.composable

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.dostap.R
import com.example.dostap.auth.data.model.AuthResult
import com.example.dostap.auth.data.model.AuthUiEvent
import com.example.dostap.auth.presentation.viewmodel.AuthViewModel
import com.example.dostap.core.data.Screen
import com.example.dostap.ui.theme.LightColorScheme
import com.example.dostap.ui.theme.defTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    viewModel: AuthViewModel = viewModel(),
    navController: NavController,
)
{
    val state = viewModel.state
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    LaunchedEffect(viewModel, context){
        viewModel.authResult.collect{result->
            when(result){
                is AuthResult.Authorized -> {
                    navController.navigate(Screen.MainScreen.route){
                        popUpTo(Screen.MainScreen.route){
                            inclusive = true
                        }
                    }
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(context, "You are not authorized", Toast.LENGTH_LONG).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(context, "Unknown Error Occurred", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1A8EEA))
    ){

        Image(painter = painterResource(id = R.drawable.wagon),
            contentDescription = "plane_ride")
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(.23f))
            Column(modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
                .background(Color(0xFFF9F9F9))
                .padding(horizontal = 30.dp)
                .padding(top = 60.dp)
            ) {
                Text(text = context.getString(R.string.login_label), style = MaterialTheme.typography.displayLarge)
                Text(text = context.getString(R.string.login_enter_login), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = context.getString(R.string.login_login_label), style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(44.dp),
                        textStyle = MaterialTheme.typography.labelLarge,
                        value = state.signInUsername,
                        onValueChange = { viewModel.onEvent(AuthUiEvent.SignInUsernameChanged(it)) },
                        placeholder={ Text(text = context.getString(R.string.login_login_placeholder), style = MaterialTheme.typography.labelLarge, modifier = Modifier
                            .fillMaxWidth())
                        },
                        isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email !="",
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Email
                        )
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = context.getString(R.string.login_password_label), style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(44.dp),
                        value = state.signInPassword,
                        textStyle = MaterialTheme.typography.labelLarge,
                        onValueChange = { viewModel.onEvent(AuthUiEvent.SignInPasswordChanged(it)) },
                        placeholder={ Text(text = "********", style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                        )},
                        modifier = Modifier
                            .fillMaxWidth()
                        ,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation(),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(text = context.getString(R.string.login_forgot_password), style = MaterialTheme.typography.titleMedium)
                }
                Spacer(modifier = Modifier.size(30.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    ,
                    enabled = !state.isLoading,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A1A1A),
                    )
                    , onClick = {
                        viewModel.onEvent(AuthUiEvent.SignIn)
                    }) {
                    if(!state.isLoading){
                        Text(text = context.getString(R.string.login_button))
                    } else {
                        CircularProgressIndicator()
                    }

                }
                Spacer(modifier = Modifier.size(10.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.padding(horizontal = 10.dp)){
                        Text(text = "Or", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp)
                    }

                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(modifier = Modifier.size(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Row(modifier = Modifier
                        .width(160.dp)
                    ){
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(70.dp)
                            .border(0.5.dp, Color(0xFF959595), MaterialTheme.shapes.medium)
                            .clickable {

                            },
                            contentAlignment = Alignment.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.google_logo), contentDescription = "google logo",
                                modifier = Modifier.size(19.dp))
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(70.dp)
                            .border(0.5.dp, Color(0xFF959595), MaterialTheme.shapes.medium),
                            contentAlignment = Alignment.Center
                        ){
                            Image(painter = painterResource(id = R.drawable.apple_logo), contentDescription = "apple logo",
                                modifier = Modifier.size(19.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.size(20.dp))
                Row(modifier = Modifier.fillMaxWidth()
                    ,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = context.getString(R.string.login_reg_text), style = MaterialTheme.typography.bodyMedium)
                    TextButton(onClick = {  }) {
                        Text(text = context.getString(R.string.login_reg_button), style = MaterialTheme.typography.bodyMedium)
                    }
                }


            }
        }
    }

}
@Preview
@Composable
fun PreviewSignIn(){
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = defTypography
    ) {
//        SignInScreen(onGoogleSignInClicked = { /*TODO*/ }, onSignInClicked = {token ->
//
//        }) {
//
//        }
    }

}