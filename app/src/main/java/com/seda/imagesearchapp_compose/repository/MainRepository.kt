package com.seda.imagesearchapp_compose.repository

import com.seda.imagesearchapp_compose.network.ApiService
import com.seda.imagesearchapp_compose.network.model.ImageResponse
import com.seda.imagesearchapp_compose.utils.Constants
import com.seda.imagesearchapp_compose.utils.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

suspend fun getQueryItems(q:String):Resource<ImageResponse>{
return try {
    val result = apiService.getQueryImages(query = q, apikey = Constants.KEY, imageType = "photo")
     Resource.Success(result)
} catch (e:Exception){
Resource.Error(message = e.message.toString())
       }
    }
}