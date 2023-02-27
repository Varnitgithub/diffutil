package com.example.diffutil

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewmodelclass(private val repository: repository):ViewModel() {

    var livedata :LiveData<List<mynote>>? = null

    init {
       val modellivedata = repository.dao.getnote()
        livedata = modellivedata
    }

   suspend fun modellivedata(mynote: mynote){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertmydata(mynote)
        }

        }
    }

