package com.example.recipeapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import java.util.Locale.Category

@Composable
fun RecipeApp( viewModel: MainViewModel= viewModel(),navToDetail:(catagory)->Unit){
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when{
            viewModel.catagoryState.value.loading->{
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
            viewModel.catagoryState.value.error!=null->{
                Text(text = "Error occur")
            }
            else->{
                //Display category screen
                CategoryScreen(categories = viewModel.catagoryState.value.list,navToDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories:List<catagory>,navToDetail:(catagory)->Unit){
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
        ) {
        items(categories){
            category->
            CategoryItem(category = category,navToDetail)

        }
    }
}

@Composable
fun CategoryItem(category:catagory,navToDetail:(catagory)->Unit){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { navToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription ="Image",
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(text = category.strCategory,
            modifier = Modifier.padding(top = 4.dp),
            style = TextStyle(fontWeight = FontWeight.Bold),
            )

    }
}