package com.seda.imagesearchapp_compose.network

import com.seda.imagesearchapp_compose.network.model.ImageResponse
import com.seda.imagesearchapp_compose.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getQueryImages(
        @Query("q") query:String,
        @Query("key") apikey:String,
        @Query("image_tyoe") imageType:String
    ):ImageResponse


}