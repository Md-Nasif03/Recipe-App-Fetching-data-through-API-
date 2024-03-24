package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(category: catagory){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(text = category.strCategory, textAlign = TextAlign.Center)
        Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription ="Image",
            modifier = Modifier
                .aspectRatio(1f)
        )
        Text(text = category.strCategoryDescription, textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState()).padding(5.dp)
        )
    }
}