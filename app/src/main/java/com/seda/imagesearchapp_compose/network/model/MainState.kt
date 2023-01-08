package com.seda.imagesearchapp_compose.network.model

data class MainState(
    val isLoading:Boolean=false,
    val data:List<Hit> = emptyList(),
    val error:String=""
)
