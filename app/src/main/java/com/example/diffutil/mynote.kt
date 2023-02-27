package com.example.diffutil

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("MYDATA")
data class mynote(@PrimaryKey(autoGenerate = true)val id:Int,val text:String)
