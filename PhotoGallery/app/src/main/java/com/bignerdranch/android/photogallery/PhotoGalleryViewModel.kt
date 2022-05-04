package com.bignerdranch.android.photogallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.photogallery.api.FlickrFetchr

class PhotoGalleryViewModel : ViewModel() {
    val galleryItemLiveData: LiveData<List<GalleryItem>>

    init {
        galleryItemLiveData = FlickrFetchr().fetchPhotos()
    }
}