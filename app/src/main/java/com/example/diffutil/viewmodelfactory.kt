package com.example.diffutil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class viewmodelfactory(private val repository: repository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewmodelclass(repository) as T
    }
}