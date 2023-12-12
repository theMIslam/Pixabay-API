package com.london.pixabay_api

data class PixModel(
    val total :Int,
    val hits:List<ImageModel>,
    val totalHits:Int
        )

data class ImageModel (
    val largeImageURL:String
        )