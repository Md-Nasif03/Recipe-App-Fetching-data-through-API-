package com.example.recipeapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class catagory(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription:String
) : Parcelable

data class catagoryResponds(
     val categories:List<catagory>
 )

