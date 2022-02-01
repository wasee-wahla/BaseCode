package com.example.basecode.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basecode.vm.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(val repository: BaseRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel() as T
            else -> throw IllegalArgumentException("ViewModel Class not found")
        }
    }
}