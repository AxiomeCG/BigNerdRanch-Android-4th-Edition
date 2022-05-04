package com.bignerdranch.android.photogallery.api

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi {
    @GET("services/rest/?method=flickr.interestingness.getList&api_key=17167b0687f5802f18e7ecfe92d7e7d9&format=json&nojsoncallback=1&extras=url_s")
    fun fetchPhotos(): Call<FlickrResponse>
}