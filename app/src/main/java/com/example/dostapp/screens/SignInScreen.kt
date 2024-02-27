package com.example.dostapp.screens

import android.util.Log
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.example.dostapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onGoogleSignInClicked: () -> Unit,
    onSignInClicked: (String, String) -> Unit,
    onSignUpClicked: () -> Unit
)
{
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
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
                Text(text = "Вход", fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 32.sp)
                Text(text = "Введите Ваш логин и пароль", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 14.sp)
                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Логин", fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(44.dp),
                        value = email,
                        onValueChange = { email = it },
                        placeholder={ Text(text = "youremail@gmail.com", fontFamily = FontFamily(
                            Font(R.font.poppins_light)
                        ),
                            fontSize = 10.sp)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
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
                    Text(text = "Пароль", fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(44.dp),
                        value = password,
                        onValueChange = { password = it },
                        placeholder={ Text(text = "********", fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 10.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                        )},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
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
                    Text(text = "Забыли пароль?", fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.size(30.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A1A1A),
                    )
                    , onClick = { onSignInClicked(email, password) }) {
                    Text(text = "Вход")
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
                                onGoogleSignInClicked()
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
                    Text(text = "Don't have an account?", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp)
                    TextButton(onClick = { onSignUpClicked() }) {
                        Text(text = "Sign Up", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp)
                    }
                }


            }
        }
    }
}
@Preview
@Composable
fun preview(){
    SignInScreen(onGoogleSignInClicked = { /*TODO*/ }, onSignInClicked = {email, password->

    }) {

    }
}