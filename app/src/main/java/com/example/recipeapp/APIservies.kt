package com.example.recipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface apiService{
    @GET("categories.php")
    suspend fun getCategories():catagoryResponds // we use categoryResponds because we need all set of data
}
private val apiCreat=Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService= apiCreat.create(apiService::class.java)

