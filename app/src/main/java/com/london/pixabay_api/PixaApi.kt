package com.london.pixabay_api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {
    @GET("api/")
    fun getImages(
        @Query("key")key:String="30183180-bd26bdaabea2b16a4f915db0f",
        @Query("q")keyWord:String,
        @Query("page")page:Int ): Call<PixModel>
}