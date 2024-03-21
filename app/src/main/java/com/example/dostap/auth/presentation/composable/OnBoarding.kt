package com.example.dostap.auth.presentation.composable

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostap.R
import com.example.dostap.auth.data.model.OnBoardingState
import com.example.dostap.ui.theme.LightColorScheme
import com.example.dostap.ui.theme.newTypography

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnBoarding(
    toSignUp: ()->Unit
){
    val context = LocalContext.current
    val states = listOf(
        OnBoardingState(1, context.getString(R.string.onBoarding1_label),context.getString(R.string.onBoarding1_body),
            R.drawable.on_boarding_1_png
        ),
        OnBoardingState(2, context.getString(R.string.onBoarding2_label),context.getString(R.string.onBoarding2_body),
            R.drawable.on_boarding_1_png),
        OnBoardingState(3, context.getString(R.string.onBoarding3_label),context.getString(R.string.onBoarding3_body),
            R.drawable.on_boarding_1_png)
    )
    var currentState by remember {
        mutableIntStateOf(0)
    }
    val colors = listOf(Color(0xFF1E1E1E), Color(0x21060606),
        Color(0xFF0D0D0D))
    val brush = Brush.verticalGradient(colors)

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF292929))
        .background(brush)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            AnimatedContent(targetState = currentState, content = {targetCount->
                when (targetCount) {
                    0 -> {
                        Column {
                            Image(painter = painterResource(id = states[0].image), contentDescription = "onboarding", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = states[0].text1, style = MaterialTheme.typography.displayMedium, color = Color.White)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = states[0].text2, style = MaterialTheme.typography.bodyMedium, color = Color.White)
                            Spacer(modifier = Modifier.size(20.dp))}
                    }
                    1 -> {
                        Column {
                            Image(painter = painterResource(id = states[1].image), contentDescription = "onboarding", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = states[1].text1, style = MaterialTheme.typography.displayMedium, color = Color.White)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = states[1].text2, style = MaterialTheme.typography.bodyMedium, color = Color.White)
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }
                    else -> {
                        Column {
                            Image(painter = painterResource(id = states[2].image), contentDescription = "onboarding", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = states[2].text1, style = MaterialTheme.typography.displayMedium, color = Color.White)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = states[2].text2, style = MaterialTheme.typography.bodyMedium, color = Color.White)
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }
                }

            }, transitionSpec = {
                slideInHorizontally(initialOffsetX = {
                    2 * it }, animationSpec = tween(durationMillis = 575)) togetherWith slideOutHorizontally(targetOffsetX = {
                    -it
                }, animationSpec = tween(durationMillis = 575))
            }, label = "")
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Stepper(selectedItem = currentState)
                Spacer(modifier = Modifier.size(50.dp))
                Button(modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        if(currentState==2){
                            toSignUp()
                        }
                        if(currentState<2){
                            currentState++
                        }

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7E2EFF)
                    )) {
                    Text(text = context.getString(R.string.next))
                }
            }
            Spacer(modifier = Modifier.size(40.dp))
            }
    }
}
@Composable
fun Stepper(selectedItem: Int){
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(3) { index ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .width(
                        animateDpAsState(
                            if (index == selectedItem) 30.dp else 15.dp,
                            label = ""
                        ).value
                    )
                    .height(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (index == selectedItem) Color(0xFF5B00ED) else Color(0xFF959595))
            )
        }
    }
}

@Preview
@Composable
fun OnBoardingPreview(){
    val context = LocalContext.current
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = newTypography
    ) {
        OnBoarding{
            Toast.makeText(context, "Sign Up", Toast.LENGTH_LONG).show()
        }
    }

}