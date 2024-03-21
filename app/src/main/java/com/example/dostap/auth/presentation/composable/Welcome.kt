package com.example.dostap.auth.presentation.composable

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dostap.R
import com.example.dostap.auth.data.model.Category
import com.example.dostap.ui.theme.DostappTheme
import kotlin.math.abs

@SuppressLint("MutableCollectionMutableState")
@Composable
fun Welcome(){
    val context = LocalContext.current
    val chosenCategories by remember {
        mutableStateOf(mutableListOf<Int>())
    }
    var showFirstColumn by remember { mutableStateOf(true) }
    var count by remember {
        mutableIntStateOf(0)
    }
    val colors = listOf(Color(0xFF1E1E1E), Color(0x21060606),
        Color(0xFF0D0D0D))
    val brush = Brush.verticalGradient(colors)
    val categories = listOf(
        listOf(Category.Bike,
            Category.Football,
            Category.Hiking,
            Category.Tennis,),
        listOf(Category.Swimming,
            Category.Hockey,
            Category.Weights,
            Category.Volleyball,),
        listOf(Category.Yoga,
            Category.Running,
            Category.Walking,
            Category.Bowling,),
        listOf(Category.IceSkating,
            Category.Skiing,
            Category.Chess,
            Category.Dancing,),
        listOf(Category.Concerts,
            Category.Music,
            Category.Movies,
            Category.Art)
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0x64000000))
        .background(brush),
        contentAlignment = Alignment.BottomCenter
    ) {
            AnimatedVisibility(
                visible = showFirstColumn,
                enter = slideInHorizontally(
                    initialOffsetX = { 2*it },
                    animationSpec = tween(575)
                ),
                exit = slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(575)
                )
            ){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .padding(horizontal = 20.dp)
                    .padding(top = 50.dp)
                    .animateContentSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    LazyColumn {
                        item {
                            Text(text = context.getString(R.string.welcome), style = MaterialTheme.typography.displayLarge)
                            Spacer(modifier = Modifier.size(20.dp))
                            Text(text = context.getString(R.string.choose_interests), style = MaterialTheme.typography.bodyMedium)
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                        items(categories){
                            CategoryRow(categories = it){cat->
                                if (cat>0){
                                    chosenCategories.add(cat)
                                    count++
                                } else {
                                    chosenCategories.remove(abs(cat))
                                    count--
                                }

                            }
                        }
                    }
                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                        enabled = count >=3,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF7E2EFF)
                        ),
                        onClick = {
                            showFirstColumn = false
                        }) {
                        Text(text = context.getString(R.string.next))
                    }
                }
            }
            AnimatedVisibility(
                    visible = !showFirstColumn,
            enter = slideInHorizontally(
                initialOffsetX = { 2*it },
                animationSpec = tween(575)
            ),
            exit = slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(575)
            )
            ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(horizontal = 20.dp)
                .padding(top = 50.dp)
                .animateContentSize(),
                verticalArrangement = Arrangement.Bottom
            ){
                Text(text = context.getString(R.string.whatareyoulookingfor), style = MaterialTheme.typography.displayLarge)
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = context.getString(R.string.choose_variants), style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.size(20.dp))
            }
            }


    }
}


@Composable
fun CategoryRow(categories: List<Category>, categoryChoosen: (Int)->Unit){

    Row(modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        CategoryItem(category = categories[0], modifier = Modifier.weight(1f),
            categoryChoosen = categoryChoosen)
        CategoryItem(category = categories[1], modifier = Modifier.weight(1f),
            categoryChoosen = categoryChoosen)
        CategoryItem(category = categories[2], modifier = Modifier.weight(1f),
            categoryChoosen = categoryChoosen)
        CategoryItem(category = categories[3], modifier = Modifier.weight(1f),
            categoryChoosen = categoryChoosen)
    }
}
@Composable
fun CategoryItem(category: Category, categoryChoosen:(Int)->Unit, modifier: Modifier){
    val context = LocalContext.current
    var isClicked by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = if (isClicked) {
                    category.color
                } else {
                    Color.White
                }
            )
            .border(1.dp, Color(0xFFF0F0F0), RoundedCornerShape(14.dp))
            .clickable {
                isClicked = !isClicked
                if (isClicked) {
                    categoryChoosen(category.id)
                } else {
                    categoryChoosen(-category.id)
                }

            },
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(painter = painterResource(id = category.image), contentDescription = "")
            Text(text = context.getString(category.text), style = MaterialTheme.typography.labelLarge)
        }
    }


}
@Preview
@Composable
fun WelcomePreview(){
    val categories = listOf(
        Category.Bike,
        Category.Football,
        Category.Hiking,
        Category.Tennis,
    )
    DostappTheme {
        Welcome()
    }


}