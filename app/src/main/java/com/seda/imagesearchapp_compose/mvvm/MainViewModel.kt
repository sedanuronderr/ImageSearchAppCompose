package com.seda.imagesearchapp_compose.mvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seda.imagesearchapp_compose.network.model.Hit
import com.seda.imagesearchapp_compose.repository.MainRepository
import com.seda.imagesearchapp_compose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel(){

val list : MutableState<List<Hit>> = mutableStateOf(emptyList())

fun getImageList(q:String){

viewModelScope.launch {
   val result= repository.getQueryItems(q)
      when(result){
          is Resource.Loading->{}

          is Resource.Error->{}

          is Resource.Success->{}
      }


}
}


}