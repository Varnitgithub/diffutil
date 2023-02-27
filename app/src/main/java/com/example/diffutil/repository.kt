package com.example.diffutil

import androidx.lifecycle.LiveData

class repository(val dao: dao) {

    fun mylivedata():LiveData<List<mynote>>{
        return dao.getnote()
    }
    suspend fun insertmydata(mynote: mynote){
        dao.insert(mynote)
    }
}