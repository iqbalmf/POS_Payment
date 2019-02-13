package com.example.a0155.myapplication.ui

import com.example.a0155.myapplication.base.BaseViewModel
import com.example.a0155.myapplication.network.PostAPI
import javax.inject.Inject

class PostListViewModel:BaseViewModel(){
    @Inject
    lateinit var postApi:PostAPI
}