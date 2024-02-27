package com.example.dostapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.dostapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    context: Context,
    onSignInClicked: ()->Unit,
    onSignUpClicked: (String, String, String) -> Unit,
    onGoogleSignInClicked: () -> Unit
){
    var email by remember {
        mutableStateOf("")
    }
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1A8EEA))
    ){

        Image(painter = painterResource(id = R.drawable.plane_ride),
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
                .verticalScroll(rememberScrollState())
            ) {
                Text(text = "Регистрация", fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 32.sp)
                Text(text = "Создайте Аккаунт", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 14.sp)
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Имя", fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(44.dp),
                        placeholder={ Text(text = "Ваше имя", fontFamily = FontFamily(Font(R.font.poppins_light)),
                            fontSize = 10.sp)},
                        value = username,
                        onValueChange = { username = it },
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
                    Text(text = "Email", fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 12.sp)
                    Spacer(modifier = Modifier.size(6.dp))
                    OutlinedTextField(
                        shape = RoundedCornerShape(44.dp),
                        value = email,
                        onValueChange = { email = it },
                        placeholder={ Text(text = "youremail@gmail.com", fontFamily = FontFamily(Font(R.font.poppins_light)),
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
                Spacer(modifier = Modifier.size(30.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A1A1A),
                    )
                    , onClick = { onSignUpClicked(username, email, password) }) {
                    Text(text = "Зарегистрироваться")
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
                ) {
                    Row(modifier = Modifier.width(160.dp)){
                        Box(modifier = Modifier
                            .height(50.dp)
                            .width(70.dp)
                            .border(0.5.dp, Color(0xFF959595), MaterialTheme.shapes.medium)
                            .clickable { onGoogleSignInClicked() },
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
                    Text(text = "Уже есть аккаунт?", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                        fontSize = 14.sp)
                    TextButton(onClick = { onSignInClicked() }) {
                        Text(text = "Войти", fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontSize = 14.sp)
                    }
                }


            }
        }
    }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ){
//        Button(onClick = { onBackClicked() }) {
//            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//        }
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Email
//            ),
//            leadingIcon = {
//                Icon(Icons.Default.MailOutline, contentDescription = null)
//            }
//        )
//        OutlinedTextField(
//            value = username,
//            onValueChange = { username = it },
//            label = { Text("Username") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Email
//            ),
//            leadingIcon = {
//                Icon(Icons.Default.MailOutline, contentDescription = null)
//            }
//        )
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Password
//            ),
//            visualTransformation = PasswordVisualTransformation(),
//            leadingIcon = {
//                Icon(Icons.Default.Lock, contentDescription = null)
//            }
//        )
//
//        OutlinedTextField(
//            value = confirmPassword,
//            onValueChange = { confirmPassword = it },
//            label = { Text("Confirm Password") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            keyboardOptions = KeyboardOptions.Default.copy(
//                keyboardType = KeyboardType.Password
//            ),
//            visualTransformation = PasswordVisualTransformation(),
//            leadingIcon = {
//                Icon(Icons.Default.Lock, contentDescription = null)
//            }
//        )
//        Button(onClick = {
//            if(password!=confirmPassword){
//                Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
//                return@Button
//            }
//            onButtonClicked(email, username, password)
//        }) {
//            Text(text = "Sign Up")
//        }
//    }
}
@Preview
@Composable
fun PreviewSignUp(){
    val context = LocalContext.current
    SignUpScreen(context = context, onSignInClicked = { /*TODO*/ }, onSignUpClicked = {a,b,c->}) {
        
    }
}