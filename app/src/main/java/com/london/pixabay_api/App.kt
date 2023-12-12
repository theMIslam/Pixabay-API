package com.london.pixabay_api

import android.app.Application

class App:Application() {

    companion object{

        lateinit var api:PixApi
    }
    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        api=retrofitService.getApi()
    }
}