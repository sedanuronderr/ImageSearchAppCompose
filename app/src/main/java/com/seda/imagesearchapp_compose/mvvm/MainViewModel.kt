package com.seda.imagesearchapp_compose.mvvm

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seda.imagesearchapp_compose.network.model.Hit
import com.seda.imagesearchapp_compose.network.model.MainState
import com.seda.imagesearchapp_compose.repository.MainRepository
import com.seda.imagesearchapp_compose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(){

val list : MutableState<MainState> = mutableStateOf(MainState())

@SuppressLint("SuspiciousIndentation")
fun getImageList(q:String){

viewModelScope.launch {
   val result= repository.getQueryItems(q)
      when(result){
          is Resource.Loading->{
              list.value = MainState(isLoading = true)
          }

          is Resource.Error->{
              list.value = MainState(error = "Something went wrong" )
          }

          is Resource.Success->{
              result.data?.hits?.let {
                  list.value= MainState(data =it )
              }

          }
      }


}
}


}