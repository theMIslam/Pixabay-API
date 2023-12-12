package com.london.pixabay_api

import android.app.Application

class App:Application() {

    companion object{

        lateinit var api:PixaApi
    }
    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        api=retrofitService.getApi()
    }
}