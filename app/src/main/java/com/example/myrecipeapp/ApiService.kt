package com.example.myrecipeapp

import com.google.gson.Gson
import retrofit2.http.GET
import  retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private  val retrofit=Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()
val recipeservice= retrofit.create(ApiService::class.java)
interface ApiService
 {
     @GET("categories.php")
     suspend fun getCategories():CategoriesResponse

 }