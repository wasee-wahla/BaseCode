package com.example.basecode.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VM : ViewModel, B : ViewBinding, R : BaseRepository> :
    AppCompatActivity() {

    lateinit var binding: B
    lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ViewModelFactory(getActivityRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())
        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getViewBinding(): B

    abstract fun getActivityRepository(): R

}