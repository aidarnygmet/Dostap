package com.example.dostap.auth.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dostap.R
import com.example.dostap.auth.data.model.Category
import com.example.dostap.ui.theme.DostappTheme

@Composable
fun Welcome(){
    val context = LocalContext.current
    val categories = listOf(
        Category.Skates,
        Category.Box,
        Category.Chess,
        Category.Skates,
        Category.Box,
        Category.Chess,
        Category.Skates,
        Category.Box,
        Category.Chess,
        Category.Skates,
        Category.Box,
        Category.Chess,
    )
    val popular = listOf(
        Category.Skates,
        Category.Box,
        Category.Chess
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF1A8EEA))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Spacer(modifier = Modifier.fillMaxHeight(.15f))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
                    .background(Color.White)
                    .padding(top = 60.dp)
                    .padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = context.getString(R.string.welcome), style = MaterialTheme.typography.displayLarge)
                Text(text = context.getString(R.string.choose_interests))
                Category(context.getString(R.string.popular_category), popular)
                Category(context.getString(R.string.sports_category), categories)
                Category(context.getString(R.string.arts_category), categories)
            }
        }
    }
}

@Composable
fun Category(name: String, categories: List<Category>){

    Box(modifier = Modifier
        .border(width = 1.dp, color = Color(0xFFAFAFAF), shape = MaterialTheme.shapes.extraSmall)
        .padding(4.dp)){
        Column{
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 20.dp)
            )
            LazyVerticalGrid(
                columns = if(categories.size>=4){GridCells.Fixed(4)} else {GridCells.Fixed(categories.size)},
            ) {
                items(categories.size) { index ->
                    CategoryItem(category = categories[index])

                }
            }
        }
    }

}

@Composable
fun CategoryItem(category: Category){
    val context = LocalContext.current
    Box(modifier = Modifier
        .width(IntrinsicSize.Min)
        .border(width = 1.dp, color = Color(0xFFAFAFAF), shape = MaterialTheme.shapes.extraSmall)
        .padding(4.dp)){
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(painter = painterResource(id = category.image), contentDescription = "category",
                modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = context.getString(category.text), fontSize = 10.sp)
        }
    }

}
@Preview
@Composable
fun WelcomePreview(){
    val categories = listOf(
        Category.Skates,
        Category.Box,
        Category.Chess,
        Category.Skates,
        Category.Box,
        Category.Chess,
        Category.Skates,
        Category.Box,
        Category.Chess,
        Category.Skates,
        Category.Box,
        Category.Chess,
    )
    DostappTheme {
        Welcome()
    }


}