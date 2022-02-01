package com.example.basecode.base

import androidx.lifecycle.ViewModel
import com.example.basecode.base.BaseRepository

abstract class BaseViewModel(val repository: BaseRepository) : ViewModel() {
}