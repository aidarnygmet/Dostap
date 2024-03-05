package com.example.dostapp.auth.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.dostapp.R
import com.example.dostapp.ui.theme.LightColorScheme
import com.example.dostapp.ui.theme.defTypography

@Composable
fun OnBoarding(
    params: OnBoardingData
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1A8EEA)),
        contentAlignment = Alignment.TopCenter
    ){
        Column {
            Spacer(modifier = Modifier.height(60.dp))
            Image(painter = painterResource(id = params.pic),
                contentDescription = "devices", modifier = Modifier.size(300.dp))
        }

        Column(modifier = Modifier
            .fillMaxSize()
        ){
            Spacer(modifier = Modifier.fillMaxHeight(.5f))
            Column(modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
                .background(Color(0xFFF9F9F9))
                .padding(horizontal = 30.dp)
                .padding(top = 47.dp)
                .padding(bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = params.label, style = MaterialTheme.typography.displayLarge, textAlign = TextAlign.Center)

                Text(text = params.body, style = MaterialTheme.typography.bodyLarge, textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 22.5.dp))

                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1A1A1A),
                    )
                    , onClick = { params.buttonClicked()}) {
                    Text(text = params.button)
                }

                Row {
                    if(params.dot == 1){
                        Dot()
                    } else {
                        Dot(color = Color(0xFF959595))
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    if(params.dot == 2){
                        Dot()
                    } else {
                        Dot(color = Color(0xFF959595))
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    if(params.dot == 3){
                        Dot()
                    } else {
                        Dot(color = Color(0xFF959595))
                    }
                }
            }
        }
    }
}
@Composable
fun Dot(
    modifier: Modifier = Modifier,
    color: Color = Color(0xFF1A8EEA),
    size: Dp = 10.dp
) {
    Box(modifier = modifier
        .size(size)
        .clip(CircleShape)
        .background(color)

    ){}
}
data class OnBoardingData(
    val label: String,
    val body: String,
    val pic: Int,
    val button: String,
    val dot: Int,
    val buttonClicked: ()->Unit
)
@Preview
@Composable
fun OnBoardingPreview(){
    val context  = LocalContext.current
    val params = OnBoardingData(
        label = context.getString(R.string.onBoarding1_label),
        body = context.getString(R.string.onBoarding1_body),
        pic = R.drawable.devices,
        button = "Далее",
        dot = 1,
        buttonClicked = {}
        )
    val params2 = OnBoardingData(
        label = context.getString(R.string.onBoarding2_label),
        body = context.getString(R.string.onBoarding2_body),
        pic = R.drawable.party,
        button = "Далее",
        dot = 2,
        buttonClicked = {}
    )
    val params3 = OnBoardingData(
        label = context.getString(R.string.onBoarding3_label),
        body = context.getString(R.string.onBoarding3_body),
        pic = R.drawable.searching,
        button = "Зарегистрироваться",
        dot = 3,
        buttonClicked = {}
    )
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = defTypography
    ) {
        OnBoarding(params3)
    }

}