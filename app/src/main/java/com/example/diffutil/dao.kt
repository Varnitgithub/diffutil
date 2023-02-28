package com.example.diffutil

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface dao {

    @Insert(onConflict = (OnConflictStrategy.IGNORE))
    suspend fun insert(mynote: mynote)

    @Query("SELECT * FROM MYDATA")
    fun getnote(): LiveData<List<mynote>>

}