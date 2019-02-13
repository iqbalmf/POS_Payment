package com.example.a0155.myapplication.base

import android.arch.lifecycle.ViewModel
import com.example.a0155.myapplication.injection.component.ViewModelInjector
import com.example.a0155.myapplication.injection.module.NetworkModule
import com.example.a0155.myapplication.ui.PostListViewModel

abstract class BaseViewModel:ViewModel(){
    /*private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()
    init {
        inject()
    }

    *//**
     * Injects the required dependencies
     *//*
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }*/
}